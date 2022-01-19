package pl.edu.amu.home.paleografia.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
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
import pl.edu.amu.home.paleografia.hibernate.factory.DocumentFactory;
import pl.edu.amu.home.paleografia.hibernate.manager.ModelManager;
import pl.edu.amu.home.paleografia.spring.SpringApplication;
import pl.edu.amu.home.paleografia.spring.entities.Document;
import pl.edu.amu.home.paleografia.spring.security.JwtTokenUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SpringApplication.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DocumentApiTest {

    private static final String API_GET_ALL = "/api/documents";
    private static final String API_GET_BY_DIFF = "/api/document/diff/1";
    private static final String API_GET_BY_CENTURY = "/api/document/century/XII";
    private static final String API_GET_ONE = "/api/document/";
    private static final String API_POST = "/security/document";

    private final Document document = DocumentFactory.createDefaultForTests();
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
                        .content( objectMapper.writeValueAsString( document ) )
                        .contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isUnauthorized() );
    }

    @Test
    @Order(1)
    void postDocument() throws Exception {
        initDataBefore();
        String token = generateToken();

        this.mockMvc
                .perform( post( API_POST )
                        .header( "Authorization", "Bearer " + token )
                        .content( objectMapper.writeValueAsString( document ) )
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
    void getDocuments() throws Exception {
        mockMvc
                .perform( get( API_GET_ALL ) )
                .andExpect( status().isOk() )
                .andExpect( content().contentType( MediaType.APPLICATION_JSON ) )
                .andReturn();
    }

    @Test
    @Order(3)
    void getDocumentByDifficulty() throws Exception {
        mockMvc
                .perform( get( API_GET_BY_DIFF ) )
                .andExpect( status().isOk() )
                .andExpect( content().contentType( MediaType.APPLICATION_JSON ) );
    }

    @Test
    @Order(4)
    void getDocumentByCentury() throws Exception {
        mockMvc
                .perform( get( API_GET_BY_CENTURY ) )
                .andExpect( status().isOk() )
                .andExpect( content().contentType( MediaType.APPLICATION_JSON ) );
    }
}
