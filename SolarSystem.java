//*******************************************************************
// Project SolarSystem
//
// Autor:                     Juan Jose Aguado
// Fecha creacion:            07/Oct/2015
// Fecha ultima modificacion: 07/Oct/2015
//
// class: SolarSystem
//
//*******************************************************************

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class SolarSystem {

   
    static private Options options = new Options();
    static private String version = "v.0Aa © 2015 JJA";

    //***************************************************************
    public static void main(String[] args) {

        int numOptions = 0;

        //System.out.println("***************************************");
        //System.out.println("SolarSystem " + version );
        //System.out.println("Start Program ");
        //System.out.println("***************************************");

        options.addOption("m", "moon",   true,  "[Moon]");
        options.addOption("p", "planet", true,  "[Mercury | Venus | Earth | Mars | Jupiter | Saturn | Uranus | Neptune | Pluto]");
        options.addOption("s", "star",   true,  "[Sun]");
        options.addOption("h", "help",   false, "Show help.");

        CommandLineParser parser = new BasicParser();

        CommandLine cmd = null;

        try {

            Map<String,String> planets =readPlanetsFile("planets.txt");
            Map<String,String> stars =readPlanetsFile("stars.txt");
            Map<String,String> moons =readPlanetsFile("moons.txt");

            cmd = parser.parse(options, args);

            if (cmd.hasOption("h")) {
                help();
            }

            else if (cmd.hasOption("p")) {
                String planetName =  cmd.getOptionValue("p");
                System.out.println( "Planet Information: " + planetName);
                String planetText = planets.get(planetName);
                if (planetText==null)  {
                    System.out.println("Planet not stored in Data Base");
                    help();
                } else {
                    System.out.println(planetText);
                }
            }

            else if (cmd.hasOption("s")) {
                String starName =  cmd.getOptionValue("s");
                System.out.println( "Star Information: " + starName);
                String starText = stars.get(starName);
                if (starText==null)  {
                    System.out.println("Star not stored in Data Base");
                    help();
                } else {
                    System.out.println(starText);
                }
            }

            else if (cmd.hasOption("m")) {
                String moonName =  cmd.getOptionValue("m");
                System.out.println( "Moon Information: " + moonName);
                String moonText = moons.get(moonName);
                if (moonText==null)  {
                    System.out.println("Moon not stored in Data Base");
                    help();
                } else {
                    System.out.println(moonText);
                }
            }

            else {
                help();
            }

        } catch (ParseException e) {
            System.out.println("Failed to parse command line properties" + e);
            help();

        } catch (FileNotFoundException e) {
            System.out.println("Failed to open planet file. " + e);

        } catch (IOException e) {
            System.out.println("Failed to open planet file. " + e);
        }

        //System.out.println("***************************************");
        //System.out.println("End Program");
        //System.out.println("***************************************");
    }


    //***************************************************************
    // Read Planets file
    //***************************************************************
    static Map<String,String> readPlanetsFile(String fname) throws FileNotFoundException, IOException {

        Map<String,String> planets = new HashMap<String,String>();
        String line="";
        BufferedReader fRd = new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
        boolean nextPlanet = false;

        while ( (line=fRd.readLine())!=null  ) {

            if (line.startsWith("=") || nextPlanet==true) {

                String planetName = "";
                if (nextPlanet==false) {
                    planetName = fRd.readLine();
                } else {
                    planetName = line;
                }

                String planetTxt = "";

                while ( (line=fRd.readLine())!=null &&  (line.startsWith("=")==false)) {
                    planetTxt += line + "\n";
                }

                planets.put(planetName, planetTxt);

                if (line.startsWith("=")==true) {
                    nextPlanet = true;
                }
            }
        }

        fRd.close();

        return planets;
    }


    //***************************************************************
    // This function prints out some help
    //***************************************************************
    static private void help() {

        HelpFormatter formater = new HelpFormatter();

        formater.printHelp("Solar System", options);
    }

}