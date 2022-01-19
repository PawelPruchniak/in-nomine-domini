package pl.edu.amu.home.paleografia.hibernate.factory;


import pl.edu.amu.home.paleografia.hibernate.DefaultString;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseGaps;
import pl.edu.amu.home.paleografia.spring.entities.Image;

import java.util.ArrayList;
import java.util.List;

import static pl.edu.amu.home.paleografia.hibernate.DifficultyLevel.DIFFICULTY_EASY;
import static pl.edu.amu.home.paleografia.hibernate.DifficultyLevel.DIFFICULTY_MEDIUM;

public class ExerciseGapsFactory {

    private static final String DOC_PATH = "/backend-images/documents/";
    private static final String LIGHT_DOC_PATH = "/backend-images/documents-small/";

    private ExerciseGapsFactory() {
        // private Constructor to hide the public one
    }

    public static List<ExerciseGaps> createModelForTesting() {
        List<ExerciseGaps> exerciseGapsList = new ArrayList<>();

        var image1 = new Image.Builder()
                .path( DOC_PATH + "fotografia_01.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_01.webp" )
                .build();
        var exerciseGaps1 = new ExerciseGaps.Builder()
                .transcription(
                        "Nos Fulko ~D(e)i gra(cia) Gneiznen(sis) eccl(es)ie archiep(is)c(opus) presens ~sc(ri)ptum inspecturis salut(em) in ~D(omi)no ~sempit(er)nam \n Univ(er)sa facta, que sanctione ~r(ati)onabiliu(m) viro(rum) ordinant(ur), ~immo ip(s)a dec(e)nte(r) ~r(ati)one ord inata roborant(ur), a ~posteris \n no(n) tantu(m) ~su(n)t firmit(er) obs(er)vanda, ~s(ed) (et) aut(e)nticis ~suis iuste ad hec postulatis aff(e)ctuosissime ~confirmanda, nam \n et maioris firmitatis est edificium, ~cui div(er)sitas colu(m)pna(rum) accomodat ~fulc imentum Nos (i)g(itur) ~donat(i)onem decima- \n t(i)onis in p(ar)te t(e)rritorii de Nakel, ~concessi p(er) bone memorie W. duce(m) ~Polonie monast(er)io de ~Lubes Wrathi(slavensis) dioc(esis) \n p(er)petuo possid(e)ndi, no(n) in p(re)iudiciu(m) ~eccl(es)ie sue ~laudabilis memorie W. antecessor n(oste)r de consensu sui capit(u)li cum \n ~sum(m)a delib(er)at(i)one factam, exp(re)ssis tam(en) certis t(er)minis d(i)c(t)i t(er)ritorii, a pp(e)nsione p(ro)prii sigilli suiq(ue) capit(u)li co(m)muni- \n vit, qua(m) p(ro)u t int(e)llexim(us) in scripto ~co(n)tin(er)i ~n(ost)ri p(re)decessoris in ~quantu(m) possum(us) n(ost)ri ~sigilli munimine roboramus \n Actum anno gracie M.CC.XXXIIII, indictione VII, X kalendas iunii \n" )
                .difficultyLevel( DIFFICULTY_MEDIUM )
                .image( image1 )
                .build();

        var image2 = new Image.Builder()
                .path( DOC_PATH + "fotografia_04.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_04.webp" )
                .build();
        var exerciseGaps2 = new ExerciseGaps.Builder()
                .transcription(
                        "In nomine ~Domini amen. Multis incomodis prudenter ~ocurrimus cum etatis nostre negocia litt(er)a(rum) et testium ~munimine roboramus. Hinc est, quod nos \n Premisl secundus Dei gra(tia) dux ~Polonie et ~Pomoranie univ(er)sis, tam presentibus ~quam futu(r)is presentem paginam (i)nspectu(r)is facimus ~manifestum, quod comes Stoygneuus \n cast(e)llanus Ruden(sis) ob ~remedium anima (rum) sue, parentum et p(ro)pinquo(rum) suo(rum), hereditatem Sagenckouo wlgari t(er) nu(n)cupatam a ~duce Polonie Boleslao ~recolende memo- \n rie, patruo ~nostro k(arissi)mo deservitam honorab(i)li d(omi)ne Censtobroni ~abbatisse de Olobok et suo conventui [iure] he(re)ditario p(er)petuo possidendam cum om(n)ibus hiis \n libertatibus, cum quibus eande(m) possedit comes Stoygneuus sup(er)ius nominat(us) ~liberam, scilicet a povoz, a prevod, a ~naraz, a strosa, a ~podvorove, a bove, a vacca, ab opole, a \n poradlne et a castri citac(i)o(n)e, ita quod si ~incole d(i)c(t)a(rum) villarum essent ad iudicium ~evocande no(n) ~coram alio set coram nob(is) comparebunt nostro ~anulo v(e)l nuncio ~p(ro)vocati \n Nos vero, ~peticionibus dilecti nostri ~baronis comitis Stoygneui et sue pie et racionab(i)li ~donacioni plenarie annuentes, eam cum plena delibera cione et maturo \n ~consilio ~confirmamus p(er)petuo valituram. Ne autem super hiis inposte(rum) valeat dubitari d(i)c(t)e ~d(omi)ne abbatisse et ~conventui suo sup(er) hoc presentes dedim(us) litt(er)as \n ~nostri sig(i)lli munimine ~roboratas, sub testimonio comitu(m) Boguslay iudicis, Vbislay pinc(er)ne, Roskonis venatoris, Sandiuoy subcamerarii Kalisiensiu(m) \n Anno domini M. C. C. nonagesimo ~quinto, indict(i)o(n)e octava, p(er) manus Nicholay sc(ri)pto(r)is curie nostre. ~Actum et datum anno et indict(i)o(n)e sup(er)ius \n no(m)i(n)atis aput Kalis in die ~ascensionis D(omi)ni." )
                .difficultyLevel( DIFFICULTY_MEDIUM )
                .image( image2 )
                .build();

        var image3 = new Image.Builder()
                .path( DOC_PATH + "fotografia_03.png" )
                .lightPath( LIGHT_DOC_PATH + "fotografia_03.webp" )
                .build();
        var exerciseGaps3 = new ExerciseGaps.Builder()
                .transcription(
                        "~In nomine Domini amen. Nov(er)int universi ~presentes litt(er)as inspecturi, quod nos Wysslaus Dei \n gra(tia) ~ep(iscopu)s eccl(es)ie Wladizlavien(sis) cu(m) ratih(ab)icione ~n(ost)ri capituli ~et consensu in villis ~Polusyno et Bruth- \n nyno ius decimale et ~decimas nob(is) et n(ost)re ~eccl(es)ie p(er)tinentes, ~que p(ro)veniu(n)t nu(n)c de ~cultis vel p(ro)venire \n de agris pot(er)unt in post(er)um excolendis, d(omi)no Johanni ~abbati et fratr(ibus) monast(er)ii de ~Luckna ordi(ni)s Cyst(er)ci- \n en(sis) in fav ~orem religionis ~damus et ~transferimus iure pleno et p(er)petuo possidendas. Insup(er) p(ro)testam(ur), q(uod) \n ~idem abbas et ~convent(us), ut se n(ost)ris ~beneficiis redderent no(n) ~i(n)gratos, duas he(re)ditates ~sui monasterii \n ~Smolino et Zhelibore cu(m) ~om(n)ib(us) ea(rum) utilitatib(us) aut p(er)tinenciis in n(ost)ram et n(ost)ro(rum) successo(rum) ~p(er)sonas \n ~n(ost)req(ue) eccl(es)ie prop(ri)etatem ac ius perpetuu(m) lib(er)alit(er) t(ra)nstuleru(n)t, qua(rum) ~possessionem accepim(us) gratuite ~nob(is) \n f(a)c(t)am. In cui(us) rei evidenciam pleniorem n(ost)ro et n(ost)ri capit(u)li ~sigillis roboravim(us) ~p(re)sens publicu(m) inst(ru)m(en)tu(m). \n Actu(m) et dat(um) anno ~Domini M. C C. nonagesimo ~octavo, ~indic(i)o(n)e undecima, XIIII. K(a)l(endas) Maii, ~presentibus \n d(omi)no Voyslao Wladizlauien(si), ~d(omi)no Loduigo Crusuicien(si) custodib(us), Johanne Wlad(izlaviensi), Panzlao C(ru)suicien(si) cano(ni)cis, f(rat)re \n Henrico p(ri)ore, f(rat)re ~Henrico d(ic)to de Ruya Lucknen(si), Stephano, Paulo Luciani ac aliis n(ost)re curie ~capell(an)is." )
                .difficultyLevel( DIFFICULTY_EASY )
                .image( image3 )
                .build();

        exerciseGapsList.add( exerciseGaps1 );
        exerciseGapsList.add( exerciseGaps2 );
        exerciseGapsList.add( exerciseGaps3 );

        return exerciseGapsList;
    }

    public static ExerciseGaps createDefaultForTests() {
        return new ExerciseGaps.Builder()
                .transcription( DefaultString.TRANSCRIPTION )
                .difficultyLevel( DIFFICULTY_EASY )
                .build();
    }
}
