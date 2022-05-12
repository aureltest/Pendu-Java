/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendufxml;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author aurel
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button A;
    @FXML
    private Button B;
    @FXML
    private Button C;
    @FXML
    private Button D;
    @FXML
    private Button E;
    @FXML
    private Button F;
    @FXML
    private Button G;
    @FXML
    private Button H;
    @FXML
    private Button I;
    @FXML
    private Button J;
    @FXML
    private Button K;
    @FXML
    private Button L;
    @FXML
    private Button M;
    @FXML
    private Button N;
    @FXML
    private Button O;
    @FXML
    private Button P;
    @FXML
    private Button Q;
    @FXML
    private Button R;
    @FXML
    private Button S;
    @FXML
    private Button T;
    @FXML
    private Button U;
    @FXML
    private Button V;
    @FXML
    private Button W;
    @FXML
    private Button X;
    @FXML
    private Button Y;
    @FXML
    private Button Z;
    
    @FXML
    private Button Recap;
    @FXML
    private Button quitter;
    @FXML
    public Button nouvellePartie;
    
    @FXML
    private ImageView AffichageDessin;
    
    @FXML
    private Label AffichageMot; //label d'affichage du mot
    @FXML
    private Label AffichageInstructions;
    
    
    
    Pendu nouveauPendu = new Pendu ();// initialiser en dehors du void pour ne pas recommencer la partie a chaque clic
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        
        if(!nouveauPendu.estPerdu){
            Button button = ((Button)event.getSource());
            String entreeButton = button.getText(); // recuperation du omn des bouttons
            System.out.println(entreeButton);

            nouveauPendu.entreeUser = entreeButton.charAt(0);
            nouveauPendu.afficheMot();
            nouveauPendu.ajouteLettre(nouveauPendu.entreeUser, nouveauPendu.motATrouver, nouveauPendu.lAffichageMot);
            nouveauPendu.DessinPendu(nouveauPendu.JoueurA.getNbErr());


            if(nouveauPendu.estGagne(nouveauPendu.motATrouver)){
                AffichageInstructions.setText("T'es un bon toi t'iras loin dans la vie !");
                FileInputStream input = new FileInputStream("src/DessinPendu/10victoire.png");
                Image image = new Image(input);
                AffichageDessin.setImage(image);
            }
            else if(nouveauPendu.JoueurA.getNbErr() == 0){
                AffichageInstructions.setText("T'as perdu ! Le mot était : ");
                AffichageMot.setText(nouveauPendu.motATrouver);
                nouveauPendu.estPerdu = true;
            }
            button.setDisable(true);
        }
        
        
    }
    
    @FXML
    private void faireNouvellePartie(ActionEvent event) throws Exception{
        
        Button button = ((Button)event.getSource());
        String entreeButton = button.getText();
        if(entreeButton.equals("Nouvelle Partie")){
                try{
                    Stage PrimaryStage = (Stage)button.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                    Scene scene = new Scene(root);
                    PrimaryStage.setScene(scene);
                    PrimaryStage.setTitle("Le pendu de la mort qui tue");
                    PrimaryStage.show();
                    nouveauPendu = new Pendu();
                }
                catch(IOException e){
                }
        }
    }
    @FXML
    private void faireQuitter(ActionEvent event) throws Exception {

        Button button = ((Button) event.getSource());
        String entreeButton = button.getText();
        if (entreeButton.equals("quitter")) {
            System.out.println("coucou");
            Platform.exit();
        }
    }
    
    @FXML
    private void AfficherRecap(ActionEvent event) throws Exception{
        String entreeButton = ((Button)event.getSource()).getText();
        if (entreeButton.equals("Recap")){
            if(nouveauPendu.verifSaisie.size() > 1){
                AffichageInstructions.setText("Recapitulatif : " +nouveauPendu.verifSaisie.toString());
            }
            else{
                AffichageInstructions.setText("Vous n'avez pas proposé de mauvaises lettres");
            }
        }
    }
    
    
    public class Pendu{
        int nbLettresBonnes;
        boolean estGagne = true;
        boolean estPerdu = false;
        char entreeUser = 0;
        String motAffiche = "";     // mot affiché dans le label
        Joueur JoueurA = new Joueur();
        ArrayList<Character> verifSaisie = new ArrayList<>();
        ArrayList<Character> lAffichageMot = new ArrayList<>();
        String motATrouver;    // mot a trouver
        boolean  nouvellePartie = false;
        
        
        public class Joueur{
            int nbErreurs;

            public Joueur() {
                this.nbErreurs=10;
            }

            public void setNbErr(int nb) {
                this.nbErreurs=nb;
            }

            public int getNbErr() {
                return this.nbErreurs;
            }
        }
         public void DessinPendu(int nbErreurs)throws Exception{
            switch (nbErreurs) {
                case 9:
                    {
                        FileInputStream input = new FileInputStream("src/DessinPendu/1.png");
                        Image image = new Image(input);
                        AffichageDessin.setImage(image);
                        break;
                    }
                case 8:
                    {
                        FileInputStream input = new FileInputStream("src/DessinPendu/2.png");
                        Image image = new Image(input);
                        AffichageDessin.setImage(image);
                        break;
                    }
                case 7:
                    {
                        FileInputStream input = new FileInputStream("src/DessinPendu/3.png");
                        Image image = new Image(input);
                        AffichageDessin.setImage(image);
                        break;
                    }
                case 6:
                    {
                        FileInputStream input = new FileInputStream("src/DessinPendu/4.png");
                        Image image = new Image(input);
                        AffichageDessin.setImage(image);
                        break;
                    }
                case 5:
                    {
                        FileInputStream input = new FileInputStream("src/DessinPendu/5.png");
                        Image image = new Image(input);
                        AffichageDessin.setImage(image);
                        break;
                    }
                case 4:
                    {
                        FileInputStream input = new FileInputStream("src/DessinPendu/6.png");
                        Image image = new Image(input);
                        AffichageDessin.setImage(image);
                        break;
                    }
                case 3:
                    {
                        FileInputStream input = new FileInputStream("src/DessinPendu/7.png");
                        Image image = new Image(input);
                        AffichageDessin.setImage(image);
                        break;
                    }
                case 2:
                    {
                        FileInputStream input = new FileInputStream("src/DessinPendu/8.png");
                        Image image = new Image(input);
                        AffichageDessin.setImage(image);
                        break;
                    }
                case 1:
                    {
                        FileInputStream input = new FileInputStream("src/DessinPendu/9.png");
                        Image image = new Image(input);
                        AffichageDessin.setImage(image);
                        break;
                    }
                case 0:
                    {
                        FileInputStream input = new FileInputStream("src/DessinPendu/10.png");
                        Image image = new Image(input);
                        AffichageDessin.setImage(image);
                        break;
                    }
                default:
                    break;
            }
         }
        
        public void ajouteLettre(char entreeUser, String motATrouver, ArrayList lAfficheMot){
            boolean bonneLettre = false;
            boolean bonneLettreIdentique = false;
            boolean mauvaiseLettre = true;
            
            for (int i = 0; i< motATrouver.length(); i++){
                if (lAfficheMot.get(i).equals(entreeUser)){
                    bonneLettreIdentique = true;
                }
                else if (entreeUser == motATrouver.charAt(i) && !lAfficheMot.get(i).equals(entreeUser) ){
                    lAffichageMot.set(i, entreeUser);
                    nbLettresBonnes += 1;
                    System.out.println(nbLettresBonnes);
                    bonneLettre = true;
                    mauvaiseLettre = false;
                }
            }
            if (mauvaiseLettre){
                JoueurA.setNbErr(JoueurA.getNbErr()-1);
                System.out.println(JoueurA.getNbErr());
                verifSaisie.add(entreeUser);
                AffichageInstructions.setText("Mauvaise lettre : " + verifSaisie.toString());
            }
            if(bonneLettre){
                AffichageInstructions.setText("Bonne Lettre");
                afficheMot();
            }
            if(bonneLettreIdentique){
                AffichageInstructions.setText("T'as déja donné cette lettre ! Fais un peu attention !");
            }
            
        }
        
        public boolean estGagne(String motATrouver){
            estGagne = nbLettresBonnes == motATrouver.length();
            return estGagne;
        }
        
        public void afficheMot(){
        for (int i = 0; i< motATrouver.length(); i++){
            if(lAffichageMot.get(i) == 0){
                lAffichageMot.add(i, '_');
            }
        }
        AffichageMot.setText(lAffichageMot.toString().replace(',', ' ').replace('[', ' ').replace(']', ' '));
        }
    }
    
    
    
    
    
    
    public String bibliotheque()throws Exception{           // n'est pas contenu dans la classe Pendu car utilisée dans la fonction d'initialisation
            int cpt= 0;
            ArrayList<String> LDico = new ArrayList<>();
            FileReader fr = new FileReader ("ODS6.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String limite = "ZYTHUMS";
        
            
            try{
                while (!line.equalsIgnoreCase(limite)) {
                    line = br.readLine();
                    line = line.toUpperCase();
                    cpt++;
                    LDico.add(line);
            }
            }
            catch(Exception e){
               System.out.println("Le probleme est" + e);
            }
            
        
            System.out.println();
        
            Random r = new Random();
            int aleatoire = r.nextInt(386262);
            String motATrouver = LDico.get(aleatoire);
            return motATrouver;
            
        }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            // TODO
            FileInputStream input = new FileInputStream("src/DessinPendu/ImageDepart.png");
            Image image = new Image(input);
            AffichageDessin.setImage(image);
                        
            nouveauPendu.motATrouver = bibliotheque();
            AffichageInstructions.setText("Bienvenue dans le pendu le plus dur DU MONDE !");
//            nouveauPendu.motATrouver = "HARIBO";
            
            for (int i = 0; i< nouveauPendu.motATrouver.length(); i++){
                nouveauPendu.lAffichageMot.add(i, '_');
                
            }
           
            this.AffichageMot.setText(nouveauPendu.lAffichageMot.toString().replace(',', ' ').replace('[', ' ').replace(']', ' '));
            }
         catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
