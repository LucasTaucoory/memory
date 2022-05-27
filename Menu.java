import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.io.Writer;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class menu{

public static void main(String[] args) {

String choix, nbjoueur, diff

System.out.println("Bonjour! Bienvenue dans votre super e souhaitez-vous faire?");
System.out.println("1 : Jouer une partie multijoueurs");
System.out.println("2 : Jouer une partie solo contre IA");
System.out.println("3 : Jouer une partie solo");



choix = sc.nextLine();

switch(choix){

	case "1":
    System.out.println("Combien de joueurs serez vous?");
    nbjoueur = sc.nextLine();
		break;

  case "2":
    System.out.println("Contre quelle difficulté d'IA voulez vous jouer? (entre 1 et 10)");
    diff = sc.nextLine();
    break;

  case "3":

    break;
