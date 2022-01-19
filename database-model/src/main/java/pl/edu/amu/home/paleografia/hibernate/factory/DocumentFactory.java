package pl.edu.amu.home.paleografia.hibernate.factory;

import pl.edu.amu.home.paleografia.hibernate.DefaultString;
import pl.edu.amu.home.paleografia.spring.entities.Document;
import pl.edu.amu.home.paleografia.spring.entities.Image;

import java.util.ArrayList;
import java.util.List;

import static pl.edu.amu.home.paleografia.hibernate.DifficultyLevel.DIFFICULTY_EASY;
import static pl.edu.amu.home.paleografia.hibernate.DifficultyLevel.DIFFICULTY_HARD;
import static pl.edu.amu.home.paleografia.hibernate.DifficultyLevel.DIFFICULTY_MEDIUM;

public class DocumentFactory {

    private static final String DOC_PATH = "/backend-images/documents/";
    private static final String LIGHT_DOC_PATH = "/backend-images/documents-small/";

    private DocumentFactory() {
        // private Constructor to hide the public one
    }

    public static List<Document> createModelForTesting() {
        List<Document> documentList = new ArrayList<>();

        var image1 = new Image.Builder()
                .path( DOC_PATH + "fotografia_01.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_01.webp" )
                .build();
        var document1 = new Document.Builder()
                .transcription(
                        "Nos Fulko D(e)i gra(cia) Gneiznen(sis) eccl(es)ie archiep(is)c(opus) presens sc(ri)ptum inspecturis salut(em) in D(omi)no sempit(er)nam \n Univ(er)sa facta, que sanctione r(ati)onabiliu(m) viro(rum) ordinant(ur), immo ip(s)a dec(e)nte(r) r(ati)one ord inata roborant(ur), a posteris \n no(n) tantu(m) su(n)t firmit(er) obs(er)vanda, s(ed) (et) aut(e)nticis suis iuste ad hec postulatis aff(e)ctuosissime confirmanda, nam \n et maioris firmitatis est edificium, cui div(er)sitas colu(m)pna(rum) accomodat fulc imentum Nos (i)g(itur) donat(i)onem decima- \n t(i)onis in p(ar)te t(e)rritorii de Nakel, concessi p(er) bone memorie W. duce(m) Polonie monast(er)io de Lubes Wrathi(slavensis) dioc(esis) \n p(er)petuo possid(e)ndi, no(n) in p(re)iudiciu(m) eccl(es)ie sue laudabilis memorie W. antecessor n(oste)r de consensu sui capit(u)li cum \n sum(m)a delib(er)at(i)one factam, exp(re)ssis tam(en) certis t(er)minis d(i)c(t)i t(er)ritorii, a pp(e)nsione p(ro)prii sigilli suiq(ue) capit(u)li co(m)muni- \n vit, qua(m) p(ro)u t int(e)llexim(us) in scripto co(n)tin(er)i n(ost)ri p(re)decessoris in quantu(m) possum(us) n(ost)ri sigilli munimine roboramus \n Actum anno gracie M.CC.XXXIIII, indictione VII, X kalendas iunii \n" )
                .description(
                        "Dokument arcybiskupa gnieźnieńskiego Pełki z 1234 roku, oryginał w Archiwum Państwowym w Poznaniu. (Cystersi lubiąż D 1)" )
                .century( "XIII" )
                .difficultyLevel( DIFFICULTY_MEDIUM )
                .image( image1 )
                .build();

        var image2 = new Image.Builder()
                .path( DOC_PATH + "fotografia_02.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_02.webp" )
                .build();
        var document2 = new Document.Builder()
                .transcription(
                        "In nomine Domini amen. Multis incomodis prudenter ocurrimus cum etatis nostre negocia litt(er)a(rum) et testium munimine roboramus. Hinc est, quod nos \n Premisl secundus Dei gra(tia) dux Polonie et Pomoranie univ(er)sis, tam presentibus quam futu(r)is presentem paginam (i)nspectu(r)is facimus manifestum, quod comes Stoygneuus \n cast(e)llanus Ruden(sis) ob remedium anima (rum) sue, parentum et p(ro)pinquo(rum) suo(rum), hereditatem Sagenckouo wlgari t(er) nu(n)cupatam a duce Polonie Boleslao recolende memo- \n rie, patruo nostro k(arissi)mo deservitam honorab(i)li d(omi)ne Censtobroni abbatisse de Olobok et suo conventui [iure] he(re)ditario p(er)petuo possidendam cum om(n)ibus hiis \n libertatibus, cum quibus eande(m) possedit comes Stoygneuus sup(er)ius nominat(us) liberam, scilicet a povoz, a prevod, a naraz, a strosa, a podvorove, a bove, a vacca, ab opole, a \n poradlne et a castri citac(i)o(n)e, ita quod si incole d(i)c(t)a(rum) villarum essent ad iudicium evocande no(n) coram alio set coram nob(is) comparebunt nostro anulo v(e)l nuncio p(ro)vocati \n Nos vero, peticionibus dilecti nostri baronis comitis Stoygneui et sue pie et racionab(i)li donacioni plenarie annuentes, eam cum plena delibera cione et maturo \n consilio confirmamus p(er)petuo valituram. Ne autem super hiis inposte(rum) valeat dubitari d(i)c(t)e d(omi)ne abbatisse et conventui suo sup(er) hoc presentes dedim(us) litt(er)as \n nostri sig(i)lli munimine roboratas, sub testimonio comitu(m) Boguslay iudicis, Vbislay pinc(er)ne, Roskonis venatoris, Sandiuoy subcamerarii Kalisiensiu(m) \n Anno domini M. C. C. nonagesimo quinto, indict(i)o(n)e octava, p(er) manus Nicholay sc(ri)pto(r)is curie nostre. Actum et datum anno et indict(i)o(n)e sup(er)ius \n no(m)i(n)atis aput Kalis in die ascensionis D(omi)ni." )
                .description(
                        "Dokument Przemysława II z 1295 roku, oryginał w Archiwum Państwowym w Poznaniu. (Cysterki Ołobok D 5)" )
                .century( "XIII" )
                .difficultyLevel( DIFFICULTY_EASY )
                .image( image2 )
                .build();

        var image3 = new Image.Builder()
                .path( DOC_PATH + "fotografia_03.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_03.webp" )
                .build();
        var document3 = new Document.Builder()
                .transcription(
                        "In nomine Domini amen. Nov(er)int universi presentes litt(er)as inspecturi, quod nos Wysslaus Dei \n gra(tia) ep(iscopu)s eccl(es)ie Wladizlavien(sis) cu(m) ratih(ab)icione n(ost)ri capituli et consensu in villis Polusyno et Bruth- \n nyno ius decimale et decimas nob(is) et n(ost)re eccl(es)ie p(er)tinentes, que p(ro)veniu(n)t nu(n)c de cultis vel p(ro)venire \n de agris pot(er)unt in post(er)um excolendis, d(omi)no Johanni abbati et fratr(ibus) monast(er)ii de Luckna ordi(ni)s Cyst(er)ci- \n en(sis) in fav orem religionis damus et transferimus iure pleno et p(er)petuo possidendas. Insup(er) p(ro)testam(ur), q(uod) \n idem abbas et convent(us), ut se n(ost)ris beneficiis redderent no(n) i(n)gratos, duas he(re)ditates sui monasterii \n Smolino et Zhelibore cu(m) om(n)ib(us) ea(rum) utilitatib(us) aut p(er)tinenciis in n(ost)ram et n(ost)ro(rum) successo(rum) p(er)sonas \n n(ost)req(ue) eccl(es)ie prop(ri)etatem ac ius perpetuu(m) lib(er)alit(er) t(ra)nstuleru(n)t, qua(rum) possessionem accepim(us) gratuite nob(is) \n f(a)c(t)am. In cui(us) rei evidenciam pleniorem n(ost)ro et n(ost)ri capit(u)li sigillis roboravim(us) p(re)sens publicu(m) inst(ru)m(en)tu(m). \n Actu(m) et dat(um) anno Domini M. C C. nonagesimo octavo, indic(i)o(n)e undecima, XIIII. K(a)l(endas) Maii, presentibus \n d(omi)no Voyslao Wladizlauien(si), d(omi)no Loduigo Crusuicien(si) custodib(us), Johanne Wlad(izlaviensi), Panzlao C(ru)suicien(si) cano(ni)cis, f(rat)re \n Henrico p(ri)ore, f(rat)re Henrico d(ic)to de Ruya Lucknen(si), Stephano, Paulo Luciani ac aliis n(ost)re curie capell(an)is." )
                .description(
                        "Dokument biskupa włocławskiego Wisława z 1298 roku, oryginał w Archiwum Państwowym w Poznaniu. (Cystersi Łekno D 5)" )
                .century( "XIII" )
                .difficultyLevel( DIFFICULTY_HARD )
                .image( image3 )
                .build();

        var image4 = new Image.Builder()
                .path( DOC_PATH + "fotografia_04.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_04.webp" )
                .build();
        var document4 = new Document.Builder()
                .transcription(
                        "In nomine Domini amen. Ad p(er)petuam rei memoriam. Wladislaus dei gr(ati)a rex Polonie n(ec) non terrarum Cracouie, Sandomirie, Syradie, Lancicie, Cuyauie, \n  Litwanie princeps supremus, Pomor(a)nie, Russieq(ue) d(omi)n(u)s et heres cunctorum memorie co(m)mendamus p(rese)ntibus et futur(is) p(rese)ncium noticiam habitur(is), q(uo)d atte(n)te \n consideratis multiplicibus fidelitatum obsequiis civium civitat(is) n(ost)re Poznanien(sis) fidelium n(ost)rorum, quibus magestati n(ost)re se gratos reddiderunt et in futuru(m) \n aucto fidelitat(is) studio se reddere pot(er)int continuo grac(i)ores, horum contemplac(i)one volentes ip(s)os speciali prerogativa consolari, eosdem cives Poznanienses \n in om(n)ibus iuribus, libertatibus, immu[n]itatibus et antiquis ac laudabilibus ip(s)orum consuetudinibus, quibus temp(or)e se(re)nissimorum principum d(omi)norum Kazi- \n miri et Lodouici divorum regum Polonie, n(ost)rorum p(re)decessorum, fruebantur et freti sunt promittimus et spondemus p(er)petuis temp(or)ibus om(n)imode conserva(r)e. \n Harum quibus sigillum n(ost)r(u)m app(e)ns(u)m est testimonio l(ite)rarum. Actum Sandomirie, f(er)ia q(ui)nta infra octavas Pasce, anno D(omi)ni mill(es)imo trecentesimo octua- \n gesimo nono, p(rese)ntibus Johanne de Tarnow Sandomir(iensi), Sandziuogio Kalizien(si) palatinis, Johanne Kaliziensi, Cristino Sandecen(si) cast(e)llanis, Jancone iudice Poz- \n nanien(si), Thomcone subpinc(er)na Cracouien(si) et aliis pluribus n(ost)ris fidelibus fidedignis. Datum per manus ven(er)a(bi)lis Zaclicze p(re)po(s)iti Sandomiriensis, aule n(ost)re \n canc(e)llarii fidelis d(i)l(e)c(t)i." )
                .description(
                        "Dokument Władysława Jagiełły z 1389 roku, oryginał w Archiwum Państwowym w Poznaniu. (Akta Miasta Poznania D 3)" )
                .century( "XIV" )
                .difficultyLevel( DIFFICULTY_MEDIUM )
                .image( image4 )
                .build();

        var image5 = new Image.Builder()
                .path( DOC_PATH + "fotografia_05.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_05.webp" )
                .build();
        var document5 = new Document.Builder()
                .transcription(
                        "Wladislaus dei gra(tia) rex Polonie, Lithwanieq(ue) p(ri)nceps supremus et heres Russie etc. Significamus tenore presencium, \n quibus expedit univ(er)sis, presentibus et futuris presencium noticiam habituris, quomodo ex hoc civibus n(ost)ris Pozn- \n aniensibus non pauca attendentes immine(re) preiudicia, dum quidam nobiles et ceteri alii domos, brasea et alia \n hui(usmo)di habitacula et edificia inter ip(s)os et infra muros civitatis vel in suburbio eius compara(r)e consuev(er)unt \n et onera cum dictis civibus civitati impo(s)ita porta(r)e contradicu(n)t. Cum itaq(ue) iniustum esse censeat(ur), ut quis hono(r)e \n gaudere debeat, qui oneri subesse recusat, volumus et presentibus dec(er)nimus, ut quicumq(ue) in dicta civi(ta)te nostra \n Pozn(aniensi) vel eius suburbio ad civitatem spectan(te) domu(m) habere vel em(er)e contingerit et litteris patentibus et p(ri)vile- \n giis autenticis ab oneribus civitatis predicte exempti no(n) fue(r)int vel al(ia)s de hoc certis plenis et legittimis \n docume(n)tis caruerint, om(n)ibus oneribus subiaceant, quibus et alii cives ac incole civitatis predicte et \n suburbiorum eius subiacere consuev(er)unt. Harum quibus sigillum nostrum presentibus est apensu(m) \n testimonio l(itter)arum. Actum in Velwn, feria sexta proxima post Letare sub an(n)o D(omi)ni mille(sim)o etc. vicesi(m)o q(ua)rto. \n Ad relac(i)on(em) ven(erabilis) Stanislay \n Czolek Regni P(olonie) viceca(n)cell(arii)" )
                .description(
                        "Dokument Władysława Jagiellończyka z 1424 roku, oryginał w Archiwum Państwowym w Poznaniu. (Akta Miasta Poznania D 450)" )
                .century( "XV" )
                .difficultyLevel( DIFFICULTY_EASY )
                .image( image5 )
                .build();

        var image6 = new Image.Builder()
                .path( DOC_PATH + "fotografia_06.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_06.webp" )
                .build();
        var document6 = new Document.Builder()
                .transcription(
                        "Iudicia magnifici domini Mathie de Bnyn incisoris \n regni et capitanei Maioris Polonie g(e)n(er)alis, feria \n tercia proxima post dominicam Misericordia Domini, \n anno millesimo quadringentesimo septuagesimo \n quinto in Costen celebrata, in quibus nob(i)les et g(e)n(er)o- \n si dom(in)i Paulus Olsziczsky [iudicex] iudex, Nicolaus Glogi- \n schewsky burgrabius nec non Albertus Gorsky \n castellanus Landen(sis) et capitaneus Wschovien(sis) \n Gywan de Golyna iudex Calisien(sis), Nicolaus Pru- \n szimsky, Johannes Szapyensky, Martinus de Nowe \n Myeszcziszko iudex Poznan(ensis) g(e)n(er)alis assessores per \n magnificen(ci)am suam ad iudicia locat(i) p(re)sideba(n)t \n iudicantes." )
                .description(
                        "Fragment księgi grodzkiej kościańskiej z roku 1475, oryginał w Archiwum Państwowym w Poznaniu. (Kościan Gr. 2 k. 19)" )
                .century( "XV" )
                .difficultyLevel( DIFFICULTY_EASY )
                .image( image6 )
                .build();

        var image7 = new Image.Builder()
                .path( DOC_PATH + "fotografia_07.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_07.webp" )
                .build();
        var document7 = new Document.Builder()
                .transcription(
                        "In nomi(n)e Domi(ni) amen.Anno Domi(ni) millesimo \n quadringentesimo nonagesimo septimo. Ad per- \n petuam rei memoriam. Cum rerum agenda(rum) \n noverca creditur cernitur q(ue) esse oblivio, que \n plerumq(ue) res actas e memoria homi(num) solet excute(re), \n nisi apicibus aut attestac(i)on(e) librorum et con- \n dignorum testiu(m) fuerint p(er) hennata, hinc est, q(uo)d \n nos Sandiuogius Czarnkowski pallatinus \n Callischien(sis), tempore pallatinatus n(ost)ri, eiusde(m) \n signanter temp(or)e expedic(i)onis bellice ea, que nobi- \n libus contingerint iudicanda, iusticia(m) promoven(dam) \n cum admi(ni)stracione iuris cupim(us) roborare. Hu(n)c \n iudicioru(m) n(ost)rorum librum constitui(mus) co(n)scribe(n)d(u)m, \n ut uniuscuiusq(ue) iusticia et verum iudiciu(m) in \n eo consignetur et memoria actuu(m) in eisde(m) reperi- \n atur. Ad q(uo)d quidem iudiciu(m) n(ost)r(u)m nob(i)les Jacobum \n Grodzynski vicepallati(nu)m n(ost)r(u)m, Albertum Wyschla- \n wski, subiudice(m) Callischien(sem) pro iudice, hon(ora)b(i)lem \n Sigism(un)d(u)m Bresth, Johannem Pomorzenski et alios \n fide dignos assessores et notariu(m) n(ost)r(u)m cum plena \n potestate om(n)ia, que iuris et iusticie eru(n)t, locavi(mus) \n et nomi(n)avi(mus), oneran(tes) eo(rum) conscie(n)tias, ut nichil \n preter iusticiam facere audea(n)t, sed Deu(m) et iusticia(m) pre \n ocul(is) haben(tes), iudiciu(m) et iusticia(m) fidel(ite)r admi(ni)st(ra)re(n) in \n locis om(n)ibus, ad que nos casus et fortu(n)a deduxerint, \n aut quib(us) occurrerit in aliquo stac(i)onis n(ost)re loco \n primo, se(cun)do et tercio, et sic deinceps ius petere aut \n iusticia(m) admi(ni)strari optare, ubi iam in tercia n(ost)ra \n stac(i)one hecips(a) iudiciain villa et hereditate Gye- \n zerzany, feria q(ua)rta, in vigilia Corp(or)is Christi ce(le)brare \n iussim(us), eo q(uia) p(er) minist(teria)lem n(ost)r(u)m locus sit certis \n terrigenis assignatus ad requirendu(m), prout rece- \n perunt ad decretu(m) iudicii n(ost)ri pro rerum certarum \n recept(i)one. Anno, die et loco ac testibus quibus s(upra)." )
                .description(
                        "Fragment księgi sądu obozowego i sądu komisarzy królewskich z roku 1497, oryginał w Archiwum Państwowym w Poznaniu. (Poznań OB, 1, k. 1)" )
                .century( "XV" )
                .difficultyLevel( DIFFICULTY_MEDIUM )
                .image( image7 )
                .build();

        var image8 = new Image.Builder()
                .path( DOC_PATH + "fotografia_08.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_08.webp" )
                .build();
        var document8 = new Document.Builder()
                .transcription(
                        "Gosthkouo \n Ex convencione, prout nob(i)lis Petrus Raszewski, stans \n coram iudicio domini capitanei, convenit ex cittacione nob(i)lem \n Dorotheam Gosthcowska, q(uo)d ip(s)a possedit et occupavit violent(er) \n sibi duos mansos agri desertos matrimonii sui in villa et here- \n ditate Gosthcowo, nullo iure competen(te). Et stans ex adverso pre- \n fata Dorothea Gosthkowska dixit: “Domine iudex, ego non possideo \n neq(ue) teneo prefatos duos mansos agri in Gosthcowo, sed pueri \n mei. Teneo quidem bona dotalicii mei, ad que se l(itte)ra mea \n dotalicialis extendit”. Et domini iudicio presiden(tes), auditis par- \n cium proposicionibus et responsis, decreverunt evasionem cita- \n cionis prefati Petri Raszewski erga eandem Dorotheam Gosth- \n kowska, et hoc ideo, quia ip(s)a domina non tenet eosdem \n mansos, sed ip(s)ius pueri prefati. Super quo prefata Dorothea \n adiudicatum solvit. \n Gosthkowo. \n Domini iudicio presiden(tes), visa l(itte)ra dotaliciali nob(i)lis Dorothee \n Gosthcowska, canen(te) super medietatem bonorum heredita- \n riorum in Gosthkowo, ip(s)am in robore conservaverunt erga \n nob(i)lem Petrum Raszewski, decrever(u)ntq(ue) sibi Dorothee dictor(um) \n bonorum tenutam et possessionem iuxta eandem dotalicialem \n l(itte)ram suam, prout lacius canit. Super quo prefata Dorothea adiu- \n dicatum solvit. \n Grizina. \n Dominus capitaneus cum dominis iudicio presiden(tibus) privilegium \n seu l(itte)ram obligatoriam nobilis Mathie, filii Johannis Zambek \n de Bandlewo, erga nobilem Boguslawam Gryzinska et filium \n ip(s)ius Jaroslaum, heredes in Gryzina, sub titulo nob(i)lis Andree \n in Gryzina, canentem super unum mansum in Dluszina, prout \n lacius canit, in robore conservavit. Cuius tenor de verbo ad verbu(m) \n sequitur et est talis: “Ego Andreas in Grizina in Charbyelino \n et Dluszina publice recognosco, quia dedimus et damus unum \n mansum videlicet Wroblowski Johanni Zambek suo pro" )
                .description(
                        "Fragment księgi grodzkiej kościańskiej (księga z lat 1498-1504), oryginał w Archiwum Państwowym w Poznaniu. (Kościan Gr. 5,k. 63 v.)" )
                .century( "XV" )
                .difficultyLevel( DIFFICULTY_HARD )
                .image( image8 )
                .build();

        var image9 = new Image.Builder()
                .path( DOC_PATH + "fotografia_09.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_09.webp" )
                .build();
        var document9 = new Document.Builder()
                .transcription(
                        "Liber resig- \n nacionum \n magnifici \n domini Am- \n brosii de Pam- \n pow palatini \n Siradien(sis) et capitanei \n Maioris Polonie gene- \n ralis de anno Domini \n millesimo quadringen- \n tesimo nonagesimo octa(v)o \n feliciter incipit. \n Actum Pozn(an)ie \n Feria q(ua)rta infra octa(vam) Omnium Sanctorum anno D(o)m(ini) \n mill(es)imo q(uad)ringen(te)simo nonagesimo octavo p(rese)ntibus ibidem genero- \n sis et nobilibus d(om)ino Stanislao Dluski burgrabio Pozn(aniensi), Dobrogo- \n stio Soboczki n(ota)rio terrestri Poznanien(si), Johanni Lukomski et \n Nicolao Dluski et Nicolao Myaskowski testibus ad p(re)m(i)ss(a)." )
                .description(
                        "Fragment księgi grodzkiej poznańskiej z roku 1498, oryginał w Archiwum Państwowym w Poznaniu. (Poznań Gr. 12,k. 1)" )
                .century( "XV" )
                .difficultyLevel( DIFFICULTY_EASY )
                .image( image9 )
                .build();

        var image10 = new Image.Builder()
                .path( DOC_PATH + "fotografia_10.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_10.webp" )
                .build();
        var document10 = new Document.Builder()
                .transcription(
                        "In nomine s(an)c(t)e individue t(ri)nitatis amen Ego Premizl divina p(er)missione dux polonie \n cu(m) dilecto f(rat)re meo Bolezlao iuniore et cu(m) karissima matre n(ost)ra d(omi)na Haduige notu(m) \n facim(us) om(n)ib(us) xpi fidelib(us) tam p(re)sentib(us) q(uam) fut(ur)is q(uo)d i(n) remediu(m) a(n)i(m)aru(m) n(ost)raru(m) et p(at)ris n(ost)ri n(ec) n(on) o(mn)ium \n p(re)decesso(rum)successo(rum)q(ue) n(ost)ro(rum) co(n)tulim(us) has villas da(m)bagora(m) Grilevo et pinzco ad honore(m) d(e)i et \n s(an)c(t)e Marie s(an)c(t)i Pet(ri) monasterio Lucne(si) et s(an)c(t)o collegio ibide(m) fam(u)lanti d(e)o iure he(re)ditario i(n) p(er)petuum \n possidendas Q(u)ib(us) villis hanc co(n)ferim(us) libertate(m) ut n(ec) podvorove n(ec) strosam n(ec) pouoz n(ec) cet(er)as iniq(ua)s \n exact(i)ones solve(re) teneant(ur) Hoc firmit(er) servari p(re)cipientes ut cora(m) om(n)ib(us) castellanis seu aliis iudicib(us) citati no(n) \n astent n(isi) cora(m) nob(is) sigillo n(ost)ro p(ro)vocati Q(u)icu(n)q(ue) au(tem) hoc felix f(a)c(tu)m n(ost)r(u)m irritare vel ausu tem(er)ario (con)traire \n p(re)su(m)ps(er)it indignat(i)one(m) d(e)i om(n)ipote(ntis) et n(ost)ram se nov(er)it i(n) cursuru(m) Et q(ui)a sigillum n(ost)r(u)m ad p(re)sens non \n habuim(us) sigillo p(at)ris n(ost)ri p(re)sens sc(ri)ptum curavim(us) com(m)unire Dat(um) an(n)o gr(aci)e M CC XXXX III f(er)ia t(er)cia ante \n cin(er)es i(n) Gnezna" )
                .description(
                        "Dokument Przemysła I, księcia wielkopolskiego z 1243 roku, oryginał w Archiwum Państwowym w Poznaniu. (Dokumenty wiejskie 117)" )
                .century( "XIII" )
                .difficultyLevel( DIFFICULTY_HARD )
                .image( image10 )
                .build();

        var image11 = new Image.Builder()
                .path( DOC_PATH + "dyplom_01.jpg" )
                .lightPath( LIGHT_DOC_PATH + "dyplom_01.webp" )
                .build();
        var document11 = new Document.Builder()
                .transcription(
                        "In nomi(n)e D(omi)ni n(ost)ri Ih(es)u Xpi(Christi) a(me)n Ego Wlodizlaws Dei gra(cia) dux Pol(o)nie notum esse cupio \n omnib(us) Xpi(Christi) fidelibus quod (con)tuli b(ea)to Pet(ro) et f(rat)rib(us) in Lugna h(uius)cemodi libertatem q(uo)d om(ne)s ville \n eo(rum) ab hiis legib(us) absolute sunt videlic(et) a podvorowe a strosa a p(re)wod a powoz a podvodi \n a castro ab expedicio(n)e ab edificacio(n)e et rep(ar)acio(n)e po(n)tis nec ullas iniquas exactiones solver \n teneant(ur) nec alicui(us) castellani v(e)l iudicis legib(us) substernant(ur) et si sine anulo ducis citati fu(er)int \n minime (com)parebu(n)t Insup(er) (con)tuli p(re)dictis f(rat)ribus lacum no(m)i(n)e Chocenicsko et familia(m) meam sub \n notatam Cys videlic(et) cum filiis Vrobl cum filiis Stephanus cu(m) filiis Nerad cum filiis \n Neprebis cum filiis Curask cum filiis Laurencius cum filiis Bertoltus cum filiis Lobota \n cum filiis Ut hec mea dona in ev(u)m rata p(er)severent dedi memoratis fratrib(us) Lugnensis \n cenobii p(re)sens privilegiu(m) meo sigillo confirmatu(m) Datum in Poznan Anno g(ra)cie M CC \n XVI XVIII Kalendas april(is) indictio(n)e quarta Cum hec fierent hii testes astiterunt \n Dobrogost palatinus Bronisi(us) castellanus Gne(z)nen(sis) Thomas castellanus de Velim Odullan(us) \n pinc(er)na Hugo Cpianus Nicolaus canonici Gneznen(ses) Zantozlavus Zlavenicus he(re)des \n cenobii supradicti et alii q(ua)m plures fide digni" )
                .description(
                        "Dokument Władysława księcia polskiego z 1216 roku, oryginał w Polskiej Akademii Nauk Bibliotece Kórnickiej (Dypl. 1)" )
                .century( "XIII" )
                .difficultyLevel( DIFFICULTY_HARD )
                .image( image11 )
                .build();

        var image12 = new Image.Builder()
                .path( DOC_PATH + "dyplom_02.jpg" )
                .lightPath( LIGHT_DOC_PATH + "dyplom_02.webp" )
                .build();
        var document12 = new Document.Builder()
                .transcription(
                        "Premizl Dei gra(cia) dux Polonie univ(er)sis tam p(re)sentib(us) qua(m) futuris ad \n quos p(re)sens scriptu(m) p(er)venerit sal(u)t(em) in Eo qui est salus omniu(m) Ad uni \n verso(rum) noticiam p(ro)venire volum(us) q(uo)d d(omi)n(u)s Hartung(us) abbas in \n Lukna p(er) Obechan Rospanche Boguphalu(m) et eo(rum) f(rat)res sup(er) h(er)edita \n te que vocatur Pang(r)oz (con)ve(n)t(us) coram nob(is) (com)probavit eandem esse \n h(er)editate(m) eccl(es)ie dicte testimonio tam digno qua(m) ydoneo qua(m) \n eidem abb(at)i ne iusticia manifestata vacillet in posteru(m) sine \n debito no(n) adepto statuim(us) circuiendam cu(m) suis co(n)metaneis \n atq(ue) more solito terminandam Abbas (i)g(itur) eam circuivit assig \n nando metas (at)q(ue) t(er)minos c(um) p(re)d(i)c(t)is Obechan scil(icet) (at)q(ue) ei(us) f(rat)ribus ex una \n parte et cu(m) co(m)ite Steph(an)o herede suo ex alt(er)a testib(us) illic assiste(n)tib(us) \n viris ydoneis q(uorum) nomina sunt hec Dyrsic(ra)ius comes palatin(us) \n Slavnic(us) cu(m) duob(us) filiis Pet(r)o et Izbyluto comes Sbyluth c(um) duobu \n filiis Sbyluth fili(us) Strassonis Stras fili(us) Pet(ri) Woyslay de Dobesev \n Iacob(us) fili(us) Slavomuri Ianic avunc(u)l(u)s filio(rum) Voycechonis et alii \n plures (at)q(ue) hii omnes s(un)t testes i(n) hac causa det(er)minate i(us)ticie \n partis ut(ri)usq(ue) Ut aute(m) causa hec cora(m) nob(is) det(er)minata robur \n firmitatis obtineat dedim(us) sup(er) hoc lit(t)eras sigilli n(ost)ri muni \n mine roboratas Dat(um) i(n) Gnezna Anno gr(aci)e M CC XL VIII" )
                .description(
                        "Dokument Przemysła I księcia polskiego z 1248 roku, oryginał w Polskiej Akademii Nauk Bibliotece Kórnickiej (Dypl. 2)" )
                .century( "XIII" )
                .difficultyLevel( DIFFICULTY_MEDIUM )
                .image( image12 )
                .build();

        var image13 = new Image.Builder()
                .path( DOC_PATH + "dyplom_10.jpg" )
                .lightPath( LIGHT_DOC_PATH + "dyplom_10.webp" )
                .build();
        var document13 = new Document.Builder()
                .transcription(
                        "Honestum om(n)i mortali hom(in)i constat e(ss)e et l(egi)t(imu)m testimoniu(m) perhib(er)e ve(r)itati Qua \n p(ro)pter universi Xpi(Christi) fideles presentem litt(er)am visuri (co)gnoscant veritatem q(uo)d in \n mei p(re)sencia Nicolai Sanzowoi filii de Gomance et plurimo(rum) p(ro)bo(rum) viro(rum) Thomezlaus \n meus (co)gnatus filius quondam comitis Falonis castellani Gneznensis sanus et compos \n mentis bona habita deliberacio(n)e consensu matris et fr(atr)is sui Dobrogosti uterini n(ec) no(n) \n meo consensu et fr(atru)m meo(rum) Falonis et Nimironis iustum suum pat(ri)monium  heredi \n tatem que vulgarit(er) Poruvchz nuncupate(ur) contulit D(e)o eiusq(ue) gl(or)iose gent(ri)ci ad gl(or)iam \n et laudem nec no(n) b(ea)to(rum) ap(osto)lo(rum) Petri et Pauli fr(atr)ib(us) cenobii Lucknensis Ordinis Cyst(erciensis) \n ibidem in D(e)i s(er)vicio piis op(er)ib(us) laborantib(us) cum om(n)ib(us) attinenciis agris pratis aquis \n nemorib(us) silvis mericis et cunctis utilitatib(us) que sunt v(e)l fie(r)i possunt in p(re)t(ac)ta heredi \n tate nu(n)c et in fut(ur)o iure heredita(r)io imp(er)petuum possidere In cuius p(er)petue rei \n memoriam presentem litt(er)am sigilli mei et fr(atr)is mei Falonis suprad(ic)tis fr(atr)ib(us) munimi(n)e roboravi" )
                .description(
                        "Dokument poświadczający nadania klasztorowi w Łeknie wsi Pokrzywnicy przez Tomasza kasztelana gnieźnieńskiego, oryginał w Polskiej Akademii Nauk Bibliotece Kórnickiej (Dypl. 10)" )
                .century( "XIII" )
                .difficultyLevel( DIFFICULTY_HARD )
                .image( image13 )
                .build();

        documentList.add( document1 );
        documentList.add( document2 );
        documentList.add( document3 );
        documentList.add( document4 );
        documentList.add( document5 );
        documentList.add( document6 );
        documentList.add( document7 );
        documentList.add( document8 );
        documentList.add( document9 );
        documentList.add( document10 );
        documentList.add( document11 );
        documentList.add( document12 );
        documentList.add( document13 );

        return documentList;
    }

    public static Document createDefaultForTests() {
        return new Document.Builder()
                .transcription( DefaultString.TRANSCRIPTION )
                .description( DefaultString.DESCRIPTION )
                .century( DefaultString.CENTURY )
                .difficultyLevel( DIFFICULTY_EASY )
                .build();
    }
}
