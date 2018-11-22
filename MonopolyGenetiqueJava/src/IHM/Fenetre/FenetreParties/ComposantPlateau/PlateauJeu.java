package IHM.Fenetre.FenetreParties.ComposantPlateau;

import Metier.Automate.Automate;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;


//CLASSE COMPORTANT LA LISTE DES CASES DU PLATEAU
public class PlateauJeu extends Parent {

   private ArrayList<Pane> listePanel = new ArrayList<>();

    public PlateauJeu(Automate automate)
    {

        Rectangle rect_plateau = new Rectangle();
        //TAILLE DU RECTANGLE ET POSITION

        rect_plateau.setHeight(604);
        rect_plateau.setWidth(604);
        rect_plateau.setX(15);
        rect_plateau.setY(110);

        //COULEUR ET CONTOUR
        rect_plateau.setFill(Color.TRANSPARENT);
        rect_plateau.setStroke(Color.BLACK);
        this.getChildren().add(rect_plateau);


    }


    public void caseDuBas()
    {
        //CASE DEPART

        Pane CaseDepart= new Pane() ;

        CaseDepart.setLayoutX(532);
        CaseDepart.setLayoutY(628);

        URL depart = getClass().getResource("Images/Case_Depart.png");
        Image i_depart = new Image(depart.toExternalForm());
        ImageView c_depart = new ImageView(i_depart);

        c_depart.setFitWidth(87);
        c_depart.setPreserveRatio(true);

        //ajout au panel de l'image et ajout du panel dans le jeu
        this.getChildren().add(CaseDepart);
        CaseDepart.getChildren().add(c_depart);
        listePanel.add(0,CaseDepart);

        c_depart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                c_depart.setLayoutX(c_depart.getLayoutX()*2);
            }
        });

        //CASE BELLEVILLE
        Pane violetBelleville = new Pane();
        //dimension du panel

        violetBelleville.setLayoutX(484);
        violetBelleville.setLayoutY(628);

        //creation de l'image
        URL belleville = getClass().getResource("Images/Case_Belleville.png");
        Image i_Belleville = new Image(belleville.toExternalForm());
        ImageView c_belleville = new ImageView(i_Belleville);

        //taille de l'image
        c_belleville.setFitWidth(48);
        c_belleville.setPreserveRatio(true);
        //ajout au panel de l'image et ajout du panel dans le jeu
        this.getChildren().add(violetBelleville);
        violetBelleville.getChildren().add(c_belleville);
        listePanel.add(1,violetBelleville);


        //CASE CAISSE DE COMMUNAUTE
        Pane PiocheCarteCommunaute = new Pane() ;

        PiocheCarteCommunaute.setLayoutX(436);
        PiocheCarteCommunaute.setLayoutY(628);

        URL commu = getClass().getResource("Images/Case_Communaute.png");
        Image i_com = new Image(commu.toExternalForm());
        ImageView c_com = new ImageView(i_com);

        c_com.setFitWidth(48);
        c_com.setPreserveRatio(true);

        //ajout au panel de l'image et ajout du panel dans le jeu
        this.getChildren().add(PiocheCarteCommunaute);
        PiocheCarteCommunaute.getChildren().add(c_com);
        listePanel.add(2,PiocheCarteCommunaute);


        //CASE LECOURBE
        Pane violetLecourbe = new Pane() ;

        violetLecourbe.setLayoutX(388);
        violetLecourbe.setLayoutY(628);


        URL lecourbe = getClass().getResource("Images/Case_Lecourbe.png");
        Image i_Lecourbe = new Image(lecourbe.toExternalForm());
        ImageView c_Lecourbe = new ImageView(i_Lecourbe);

        c_Lecourbe.setFitWidth(48);
        c_Lecourbe.setPreserveRatio(true);

        this.getChildren().add(violetLecourbe);
        violetLecourbe.getChildren().add(c_Lecourbe);
        listePanel.add(3,violetLecourbe);


        //CASE IMPOT SUR LE REVENU
        Pane CaseImpotRevenu = new Pane() ;


        CaseImpotRevenu.setLayoutX(340);
        CaseImpotRevenu.setLayoutY(628);

        URL impot = getClass().getResource("Images/Case_Impot.png");
        Image i_impot = new Image(impot.toExternalForm());
        ImageView c_impot = new ImageView(i_impot);

        c_impot.setFitWidth(48);
        c_impot.setPreserveRatio(true);

        this.getChildren().add(CaseImpotRevenu);
        CaseImpotRevenu.getChildren().add(c_impot);
        listePanel.add(4,CaseImpotRevenu);


        //GARE DE MONTPARNASSE

        Pane gareMontparnasse = new Pane() ;


        gareMontparnasse.setLayoutX(292);
        gareMontparnasse.setLayoutY(628);


        URL gareM = getClass().getResource("Images/Case_GareM.png");
        Image i_gareM = new Image(gareM.toExternalForm());
        ImageView c_gareM = new ImageView(i_gareM);

        c_gareM.setFitWidth(48);
        c_gareM.setPreserveRatio(true);

        this.getChildren().add(gareMontparnasse);
        gareMontparnasse.getChildren().add(c_gareM);
        listePanel.add(5,gareMontparnasse);


        //CASE RUE DE VAUGIRAD

        Pane CaseVaugirad = new Pane() ;

        CaseVaugirad.setLayoutX(244);
        CaseVaugirad.setLayoutY(628);


        URL vaugirard = getClass().getResource("Images/Case_Vaugirard.png");
        Image i_vaugirard = new Image(vaugirard.toExternalForm());
        ImageView c_vaugirard = new ImageView(i_vaugirard);

        c_vaugirard.setFitWidth(48);
        c_vaugirard.setPreserveRatio(true);

        this.getChildren().add(CaseVaugirad);
        CaseVaugirad.getChildren().add(c_vaugirard);
        listePanel.add(6,CaseVaugirad);


        //CASE CHANCE
        Pane CaseChance = new Pane() ;

        CaseChance.setLayoutX(196);
        CaseChance.setLayoutY(628);

        URL chance = getClass().getResource("Images/Case_Chance.png");
        Image i_chance = new Image(chance.toExternalForm());
        ImageView c_chance = new ImageView(i_chance);

        c_chance.setFitWidth(48);
        c_chance.setPreserveRatio(true);

        this.getChildren().add(CaseChance);
        CaseChance.getChildren().add(c_chance);
        listePanel.add(7,CaseChance);


        //CASE RUE DE COURCELLES

        Pane CaseCourcelle = new Pane() ;


        CaseCourcelle.setLayoutX(148);
        CaseCourcelle.setLayoutY(628);


        URL courcelles = getClass().getResource("Images/Case_Courcelles.png");
        Image i_courcelles = new Image(courcelles.toExternalForm());
        ImageView c_courcelles = new ImageView(i_courcelles);

        c_courcelles.setFitWidth(48);
        c_courcelles.setPreserveRatio(true);

        this.getChildren().add(CaseCourcelle);
        CaseCourcelle.getChildren().add(c_courcelles);
        listePanel.add(8,CaseCourcelle);

        //CASE RUE REPUBLIQUE
        Pane CaseRepublique = new Pane() ;


        CaseRepublique.setLayoutX(100);
        CaseRepublique.setLayoutY(628);


        URL republique = getClass().getResource("Images/Case_Republique.png");
        Image i_republique = new Image(republique.toExternalForm());
        ImageView c_republique = new ImageView(i_republique);

        c_republique.setFitWidth(48);
        c_republique.setPreserveRatio(true);

        this.getChildren().add(CaseRepublique);
        CaseRepublique.getChildren().add(c_republique);
        listePanel.add(9,CaseRepublique);

        //CASE PRISON
        Pane CasePrison = new Pane() ;

        CasePrison.setLayoutX(15);
        CasePrison.setLayoutY(628);

        URL prison = getClass().getResource("Images/Case_Prison.png");
        Image i_prison = new Image(prison.toExternalForm());
        ImageView c_prison = new ImageView(i_prison);

        c_prison.setFitWidth(87);
        c_prison.setPreserveRatio(true);

        this.getChildren().add(CasePrison);
        CasePrison.getChildren().add(c_prison);
        listePanel.add(10,CasePrison);



    }

    public void caseDeGauche() {

///////////////////////////////////////////////////////////////////////////////////GROUPE VIOLET CLAIR
        ///////CASE DE LA VILETTE

        Pane caseVillette = new Pane();

        caseVillette.setLayoutX(15);
        caseVillette.setLayoutY(580);

        URL villette = getClass().getResource("Images/Case_Villette.png");
        Image i_villette = new Image(villette.toExternalForm());
        ImageView c_villette = new ImageView(i_villette);

        c_villette.setFitHeight(48);
        c_villette.setPreserveRatio(true);

        caseVillette.getChildren().add(c_villette);
        listePanel.add(11,caseVillette);

        //Si on clique sur l'image
        caseVillette.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        this.getChildren().add(caseVillette);

///////CASE NEUILLY

        Pane caseNeuilly = new Pane();

        caseNeuilly.setLayoutX(15);
        caseNeuilly.setLayoutY(484);

        URL neuilly = getClass().getResource("Images/Case_Neuilly.png");
        Image i_neuilly = new Image(neuilly.toExternalForm());
        ImageView c_neuilly = new ImageView(i_neuilly);

        c_neuilly.setFitHeight(48);
        c_neuilly.setPreserveRatio(true);

        caseNeuilly.getChildren().add(c_neuilly);
        listePanel.add(12,caseNeuilly);
        this.getChildren().add(caseNeuilly);

///////CASE PARADIS

        Pane caseParadis = new Pane();

        caseParadis.setLayoutX(15);
        caseParadis.setLayoutY(436);
        listePanel.add(13,caseParadis);

        URL paradis = getClass().getResource("Images/Case_Paradis.png");
        Image i_paradis = new Image(paradis.toExternalForm());
        ImageView c_paradis = new ImageView(i_paradis);

        c_paradis.setFitHeight(48);
        c_paradis.setPreserveRatio(true);

        caseParadis.getChildren().add(c_paradis);
        this.getChildren().add(caseParadis);

///////////////////////////////////////////////////////////////////////////////////COMPAGNIE ELECTRICITE

        Pane caseCElectr = new Pane();

        caseCElectr.setLayoutX(15);
        caseCElectr.setLayoutY(532);

        URL celectr = getClass().getResource("Images/Case_CElect-15.png");
        Image i_celectr = new Image(celectr.toExternalForm());
        ImageView c_celectr = new ImageView(i_celectr);

        c_celectr.setFitHeight(48);
        c_celectr.setPreserveRatio(true);

        listePanel.add(caseCElectr);
        caseCElectr.getChildren().add(c_celectr);
        this.getChildren().add(14,caseCElectr);

///////////////////////////////////////////////////////////////////////////////////GARE DE LYON

        Pane caseGareL = new Pane();

        caseGareL.setLayoutX(15);
        caseGareL.setLayoutY(388);


        URL gareL = getClass().getResource("Images/Case_GareL.png");
        Image i_gareL = new Image(gareL.toExternalForm());
        ImageView c_gareL = new ImageView(i_gareL);

        caseGareL.setBackground(new Background(new BackgroundImage(i_gareL, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));

        c_gareL.setFitHeight(48);
        c_gareL.setPreserveRatio(true);
        listePanel.add(15,caseGareL);
        caseGareL.getChildren().add(c_gareL);
        this.getChildren().add(caseGareL);
///////////////////////////////////////////////////////////////////////////////////GROUPE ORANGE
///////CASE Mozart

        Pane caseMozart = new Pane();

        caseMozart.setLayoutX(15);
        caseMozart.setLayoutY(340);

        URL mozart = getClass().getResource("Images/Case_Mozart.png");
        Image i_mozart = new Image(mozart.toExternalForm());
        ImageView c_mozart = new ImageView(i_mozart);

        c_mozart.setFitHeight(48);
        c_mozart.setPreserveRatio(true);

        listePanel.add(16,caseMozart);
        caseMozart.getChildren().add(c_mozart);
        this.getChildren().add(caseMozart);

///////CASE SAINT MICHELLE

        Pane caseSaintM = new Pane();

        caseSaintM.setLayoutX(15);
        caseSaintM.setLayoutY(244);

        URL saintM = getClass().getResource("Images/Case_SaintM.png");
        Image i_saintM = new Image(saintM.toExternalForm());
        ImageView c_saintM = new ImageView(i_saintM);

        c_saintM.setFitHeight(48);
        c_saintM.setPreserveRatio(true);

        listePanel.add(17,caseSaintM);
        caseSaintM.getChildren().add(c_saintM);
        this.getChildren().add(caseSaintM);

///////CASE PIGALLE

        Pane casePigalle = new Pane();

        casePigalle.setLayoutX(15);
        casePigalle.setLayoutY(196);

        URL pigalle = getClass().getResource("Images/Case_Pigalle.png");
        Image i_pigalle = new Image(pigalle.toExternalForm());
        ImageView c_pigalle = new ImageView(i_pigalle);

        c_pigalle.setFitHeight(48);
        c_pigalle.setPreserveRatio(true);

        listePanel.add(18,casePigalle);
        casePigalle.getChildren().add(c_pigalle);
        this.getChildren().add(casePigalle);

///////////////////////////////////////////////////////////////////////////////////CAISSE COMMUNAUTEE

        Pane caseCommunautee = new Pane();

        caseCommunautee.setLayoutX(35);
        caseCommunautee.setLayoutY(272);

        URL commu = getClass().getResource("Images/Case_Communaute.png");
        Image i_com = new Image(commu.toExternalForm());
        ImageView c_com = new ImageView(i_com);

        c_com.setRotate(90);
        c_com.setFitWidth(48);
        c_com.setPreserveRatio(true);

        listePanel.add(19,caseCommunautee);
        caseCommunautee.getChildren().add(c_com);
        this.getChildren().add(caseCommunautee);

///////////////////////////////////////////////////////////////////////////////////PARC GRATUIT

        Pane caseParc = new Pane();

        caseParc.setLayoutX(15);
        caseParc.setLayoutY(110);

        URL parc = getClass().getResource("Images/Case_Parc.png");
        Image i_parc = new Image(parc.toExternalForm());
        ImageView c_parc = new ImageView(i_parc);

        c_parc.setFitWidth(87);
        c_parc.setPreserveRatio(true);

        listePanel.add(20,caseParc);
        caseParc.getChildren().add(c_parc);
        this.getChildren().add(caseParc);

    }

    public void caseDuHaut()
    {
        //CASE MATIGNON
        Pane CaseMatignon = new Pane();
        CaseMatignon.setLayoutX(100);
        CaseMatignon.setLayoutY(110);

        URL matignon = getClass().getResource("Images/Case_Matignon.png");
        Image i_matignon = new Image(matignon.toExternalForm());
        ImageView c_matignon = new ImageView(i_matignon);
        listePanel.add(21,CaseMatignon);

        c_matignon.setFitWidth(48);
        c_matignon.setPreserveRatio(true);

        this.getChildren().add(CaseMatignon);
        CaseMatignon.getChildren().add(c_matignon);

///////////////CASE CHANCE
        Pane CaseChance = new Pane();
        CaseChance.setLayoutX(148);
        CaseChance.setLayoutY(110);

        URL chance = getClass().getResource("Images/Case_Chance.png");
        Image i_chance = new Image(chance.toExternalForm());
        ImageView c_chance = new ImageView(i_chance);

        c_chance.setFitWidth(48);
        c_chance.setPreserveRatio(true);
        c_chance.setRotate(180);

        listePanel.add(22,CaseChance);
        this.getChildren().add(CaseChance);
        CaseChance.getChildren().add(c_chance);

/////////////CASE MALSHERBES
        Pane CaseMalesherbes = new Pane() ;

        CaseMalesherbes.setLayoutX(196);
        CaseMalesherbes.setLayoutY(110);

        URL malesherbes = getClass().getResource("Images/Case_Malesherbes.png");
        Image i_malesherbes = new Image(malesherbes.toExternalForm());
        ImageView c_malesherbes = new ImageView(i_malesherbes);

        c_malesherbes.setFitWidth(48);
        c_malesherbes.setPreserveRatio(true);

        listePanel.add(23,CaseMalesherbes);
        this.getChildren().add(CaseMalesherbes);
        CaseMalesherbes.getChildren().add(c_malesherbes);

//////////////////////CASE HENRI MARTIN
        Pane CaseHenri = new Pane() ;

        CaseHenri.setLayoutX(244);
        CaseHenri.setLayoutY(110);

        URL henriM = getClass().getResource("Images/Case_HenriM.png");
        Image i_henriM = new Image(henriM.toExternalForm());
        ImageView c_henriM = new ImageView(i_henriM);

        listePanel.add(24,CaseHenri);
        c_henriM.setFitWidth(48);
        c_henriM.setPreserveRatio(true);

        this.getChildren().add(CaseHenri);
        CaseHenri.getChildren().add(c_henriM);

///////////GARE DU NORD
        Pane gareNord = new Pane() ;
        gareNord.setLayoutX(292);
        gareNord.setLayoutY(110);

        URL gareN = getClass().getResource("Images/Case_GareN.png");
        Image i_gareN = new Image(gareN.toExternalForm());
        ImageView c_gareN = new ImageView(i_gareN);

        c_gareN.setFitWidth(48);
        c_gareN.setPreserveRatio(true);
        listePanel.add(25,gareNord);
        this.getChildren().add(gareNord);
        gareNord.getChildren().add(c_gareN);

/////////////CASE SAINT HONORE
        Pane CaseHonore = new Pane() ;
        CaseHonore.setLayoutX(340);
        CaseHonore.setLayoutY(110);

        URL faubourgSH = getClass().getResource("Images/Case_FaubourgSH.png");
        Image i_faubourgSH = new Image(faubourgSH.toExternalForm());
        ImageView c_faubourgSH = new ImageView(i_faubourgSH);

        c_faubourgSH.setFitWidth(48);
        c_faubourgSH.setPreserveRatio(true);

        listePanel.add(26,CaseHonore);
        this.getChildren().add(CaseHonore);
        CaseHonore.getChildren().add(c_faubourgSH);

//////////////////CASE PLACE DE LA BOURSE
        Pane CaseBourse = new Pane() ;
        CaseBourse.setLayoutX(388);
        CaseBourse.setLayoutY(110);

        URL bourse = getClass().getResource("Images/Case_Bourse.png");
        Image i_bourse = new Image(bourse.toExternalForm());
        ImageView c_bourse = new ImageView(i_bourse);

        c_bourse.setFitWidth(48);
        c_bourse.setPreserveRatio(true);

        listePanel.add(27,CaseBourse);
        this.getChildren().add(CaseBourse);
        CaseBourse.getChildren().add(c_bourse);

/////////////////CASE DE COMPAGNIE DES EAUX
        Pane CaseEau = new Pane() ;
        CaseEau.setLayoutX(436);
        CaseEau.setLayoutY(110);

        URL ceaux = getClass().getResource("Images/Case_CEaux.png");
        Image i_ceaux = new Image(ceaux.toExternalForm());
        ImageView c_ceaux = new ImageView(i_ceaux);

        c_ceaux.setFitWidth(48);
        c_ceaux.setPreserveRatio(true);

        listePanel.add(28,CaseEau);
        this.getChildren().add(CaseEau);
        CaseEau.getChildren().add(c_ceaux);

//////////////CASE LA FAYETTE
        Pane CaseFayette = new Pane() ;
        CaseFayette.setLayoutX(484);
        CaseFayette.setLayoutY(110);

        URL lafayette = getClass().getResource("Images/Case_Lafayette.png");
        Image i_lafayette = new Image(lafayette.toExternalForm());
        ImageView c_lafayette = new ImageView(i_lafayette);

        c_lafayette.setFitWidth(48);
        c_lafayette.setPreserveRatio(true);

        listePanel.add(29,CaseFayette);
        this.getChildren().add(CaseFayette);
        CaseFayette.getChildren().add(c_lafayette);


    }

    public void caseDeDroite()
    {
///////////////////////////////////////////////////////////////////////////////////ALLER PRISON
        Pane caseAPrison = new Pane();

        caseAPrison.setLayoutX(532);
        caseAPrison.setLayoutY(110);

        URL allez_prison = getClass().getResource("Images/Case_Allez_Prison.png");
        Image i_aprison = new Image(allez_prison.toExternalForm());
        ImageView c_aprison = new ImageView(i_aprison);

        c_aprison.setFitHeight(87);
        c_aprison.setPreserveRatio(true);

        listePanel.add(30,caseAPrison);
        caseAPrison.getChildren().add(c_aprison);
        this.getChildren().add(caseAPrison);
///////////////////////////////////////////////////////////////////////////////////GROUPE VERT
        ///////CASE DE BRETEUIL
        Pane caseBreteuil = new Pane();

        caseBreteuil.setLayoutX(532);
        caseBreteuil.setLayoutY(196);

        URL breteuil = getClass().getResource("Images/Case_Breteuil.png");
        Image i_breteuil = new Image(breteuil.toExternalForm());
        ImageView c_breteuil = new ImageView(i_breteuil);

        c_breteuil.setFitHeight(48);
        c_breteuil.setPreserveRatio(true);
        listePanel.add(31,caseBreteuil);
        caseBreteuil.getChildren().add(c_breteuil);
        this.getChildren().add(caseBreteuil);

        ///////CASE DE FOCH
        Pane caseFoch = new Pane();

        caseFoch.setLayoutX(532);
        caseFoch.setLayoutY(244);

        URL foch = getClass().getResource("Images/Case_Foch.png");
        Image i_foch = new Image(foch.toExternalForm());
        ImageView c_foch = new ImageView(i_foch);

        c_foch.setFitHeight(48);
        c_foch.setPreserveRatio(true);
        listePanel.add(32,caseFoch);
        caseFoch.getChildren().add(c_foch);
        this.getChildren().add(caseFoch);

        ///////CASE DE CAPUCINES
        Pane caseCapucine = new Pane();

        caseCapucine.setLayoutX(532);
        caseCapucine.setLayoutY(340);

        URL capucines = getClass().getResource("Images/Case_Capucines.png");
        Image i_capucines = new Image(capucines.toExternalForm());
        ImageView c_capucines = new ImageView(i_capucines);

        c_capucines.setFitHeight(48);
        c_capucines.setPreserveRatio(true);

        listePanel.add(33,caseCapucine);
        caseCapucine.getChildren().add(c_capucines);
        this.getChildren().add(caseCapucine);

///////////////////////////////////////////////////////////////////////////////////CAISSE DE COMMUNAUTEE
        Pane caseCommunautee = new Pane();

        caseCommunautee.setLayoutX(552);
        caseCommunautee.setLayoutY(272);

        URL commu3 = getClass().getResource("Images/Case_Communaute.png");
        Image i_commu3 = new Image(commu3.toExternalForm());
        ImageView c_commu3 = new ImageView(i_commu3);

        c_commu3.setFitWidth(48);
        c_commu3.setPreserveRatio(true);
        c_commu3.setRotate(-90);
        listePanel.add(caseCommunautee);
        caseCommunautee.getChildren().add(c_commu3);
        this.getChildren().add(34,caseCommunautee);


///////////////////////////////////////////////////////////////////////////////////GARE
        Pane caseGareSL = new Pane();

        caseGareSL.setLayoutX(532);
        caseGareSL.setLayoutY(388);

        URL gareSL = getClass().getResource("Images/Case_GareSL.png");
        Image i_gareSL = new Image(gareSL.toExternalForm());
        ImageView c_gareSL = new ImageView(i_gareSL);

        c_gareSL.setFitHeight(48);
        c_gareSL.setPreserveRatio(true);
        listePanel.add(caseGareSL);
        caseGareSL.getChildren().add(c_gareSL);
        this.getChildren().add(35,caseGareSL);
///////////////////////////////////////////////////////////////////////////////////CHANCE
        Pane caseChance = new Pane();

        caseChance.setLayoutX(552);
        caseChance.setLayoutY(416);

        URL chance = getClass().getResource("Images/Case_Chance.png");
        Image i_chance = new Image(chance.toExternalForm());
        ImageView c_chance = new ImageView(i_chance);

        c_chance.setRotate(-90);
        c_chance.setFitWidth(48);
        c_chance.setPreserveRatio(true);

        listePanel.add(caseChance);
        caseChance.getChildren().add(c_chance);
        this.getChildren().add(36,caseChance);
///////////////////////////////////////////////////////////////////////////////////GROUPE BLEU FONCE
        ///////CASE DES CHAMPS ELYSEES
        Pane caseChampE = new Pane();

        caseChampE.setLayoutX(532);
        caseChampE.setLayoutY(484);

        URL champsE = getClass().getResource("Images/Case_ChampsE.png");
        Image i_champsE = new Image(champsE.toExternalForm());
        ImageView c_champsE = new ImageView(i_champsE);

        c_champsE.setFitHeight(48);
        c_champsE.setPreserveRatio(true);

        listePanel.add(37,caseChampE);
        caseChampE.getChildren().add(c_champsE);
        this.getChildren().add(caseChampE);

        ///////CASE DE LA PAIX
        Pane casePaix = new Pane();

        casePaix.setLayoutX(532);
        casePaix.setLayoutY(580);

        URL paix = getClass().getResource("Images/Case_Paix.png");
        Image i_paix = new Image(paix.toExternalForm());
        ImageView c_paix = new ImageView(i_paix);

        c_paix.setFitHeight(48);
        c_paix.setPreserveRatio(true);


        casePaix.getChildren().add(c_paix);
        this.getChildren().add(casePaix);

///////////////////////////////////////////////////////////////////////////////////TAXE DE LUXE
        Pane caseTaxe = new Pane();

        caseTaxe.setLayoutX(532);
        caseTaxe.setLayoutY(532);

        URL taxe = getClass().getResource("Images/Case_Taxe.png");
        Image i_taxe = new Image(taxe.toExternalForm());
        ImageView c_taxe = new ImageView(i_taxe);

        c_taxe.setFitHeight(48);
        c_taxe.setPreserveRatio(true);

        caseTaxe.getChildren().add(c_taxe);
        this.getChildren().add(caseTaxe);
        listePanel.add(38,caseTaxe);
        listePanel.add(39,casePaix);
    }

    public void plateauJeu(){

////////IMAGES
        URL logo_centre = getClass().getResource("Images/logo-centre.png");
        Image image = new Image(logo_centre.toExternalForm());
        ImageView imageView = new ImageView(image);

/////////TAILLE DES IMAGES
        //logo centre
        imageView.setFitWidth(350);
        imageView.setPreserveRatio(true);

/////////POSITION IMAGE
        //logo centre
        imageView.setX(145);
        imageView.setY(235);
////////AJOUT
        this.getChildren().add(imageView);

    }

    public ArrayList<Pane> getListePanel(){
        return listePanel ;
    }

}
