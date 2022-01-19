package pl.edu.amu.home.paleografia.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import pl.edu.amu.home.paleografia.hibernate.factory.ExerciseShortcutsFactory;
import pl.edu.amu.home.paleografia.hibernate.manager.ModelManager;
import pl.edu.amu.home.paleografia.spring.SpringApplication;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseShortcuts;
import pl.edu.amu.home.paleografia.spring.security.JwtTokenUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SpringApplication.class)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
class ExerciseShortcutsApiTest {

    private static final String API_GET_ALL = "/api/exercisesShortcuts";
    private static final String API_GET_ONE = "/api/exerciseShortcuts/";
    private static final String API_POST = "/security/exerciseShortcuts";

    private final ExerciseShortcuts exerciseShortcuts = ExerciseShortcutsFactory.createDefaultForTests();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;

    @Value("${jwt.secret.login}")
    private String login;

    @Test
    @Order(0)
    void shouldNotAllowPostWithoutToken() throws Exception {
        this.mockMvc
                .perform( post( API_POST )
                        .content( objectMapper.writeValueAsString( exerciseShortcuts ) )
                        .contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isUnauthorized() );
    }

    @Test
    @Order(1)
    void postExerciseShortcuts() throws Exception {
        initDataBefore();
        String token = generateToken();

        this.mockMvc
                .perform( post( API_POST )
                        .header( "Authorization", "Bearer " + token )
                        .content( objectMapper.writeValueAsString( exerciseShortcuts ) )
                        .contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isCreated() );
    }

    private void initDataBefore() {
        var modelManager = new ModelManager();
        modelManager.init();
    }

    private String generateToken() {
        final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername( login );
        return jwtTokenUtil.generateToken( userDetails );
    }

    @Test
    @Order(2)
    void getAllExercisesShortcuts() throws Exception {
        mockMvc
                .perform( get( API_GET_ALL ) )
                .andExpect( status().isOk() )
                .andExpect( content().contentType( MediaType.APPLICATION_JSON ) )
                .andReturn();
    }
}
