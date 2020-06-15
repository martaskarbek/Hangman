import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Capitals {

    public String[] capitalsRead() {
        final ArrayList<String> CapitalsFromFile = new ArrayList<>();
        int a = 0;
        String CapitalFromFile = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/jadwiga.skarbek/Java/SI/Hangman/Hangman/countries_and_capitals"));
            while ((CapitalFromFile = reader.readLine()) != null){
                CapitalsFromFile.add(CapitalFromFile);
                a += 1;
            }
            reader.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        final String[] Pairs = new String[a];
        final String[] readedCapitals = new String[a];
        for (int i = 0; i < a; i ++) {
            Pairs[i] = CapitalsFromFile.get(i);
            int CityIndex = Pairs[i].indexOf("|") + 2;
            String City = Pairs[i].substring(CityIndex);
            readedCapitals[i] = City;
        }
        return readedCapitals;
    }

    public String[] countriesRead() {
        final ArrayList<String> CountriesFromFile = new ArrayList<>();
        int a = 0;
        String CapitalFromFile = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/jadwiga.skarbek/Java/SI/Hangman/Hangman/countries_and_capitals"));
            while ((CapitalFromFile = reader.readLine()) != null){
                CountriesFromFile.add(CapitalFromFile);
                a += 1;
            }
            reader.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        final String[] Pairs = new String[a];
        final String[]  readedCountries = new String[a];
        for (int i = 0; i < a; i ++) {
            Pairs[i] = CountriesFromFile.get(i);
            int CountryIndex = Pairs[i].indexOf("|") - 1;
            String Country = Pairs[i].substring(0, CountryIndex);
            readedCountries[i] = Country;
        }
        return readedCountries;
    }
}
