import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ZooTest {
    @Test
    //test, który sprawdza czy gdy się wywoła metodę getName to będzie zwracąć Tofik
    public void getPetName_mockedPetWhichReturnsTofikName_ExpectedTofik(){
        String expected  = "Tofik";
        Pet pet = mock(Pet.class); // atrapa
        when(pet.getName()).thenReturn("Tofik"); //jeśli będize wyołana metoda getName to będzie zwracać nazwę Tofik
        Zoo zoo = new Zoo(); // tworzymy instancje klasy
        zoo.giveHomelessPet(pet); //dodaliśmy zwierzątko do listy

        String actual = zoo.getPetNames(); //

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void getPetNames_mockedPetWhichReturnsTofikName_ExpectedTofik(){

        String expected  = "Tofik, Tofik, Tofik, Tofik";
        Pet pet = mock(Pet.class); // atrapa
        when(pet.getName()).thenReturn("Tofik"); //jeśli będize wyołana metoda getName to będzie zwracać nazwę Tofik
        Zoo zoo = new Zoo(); // tworzymy instancje klasy
        zoo.giveHomelessPet(pet); //dodaliśmy zwierzątko do listy
        zoo.giveHomelessPet(pet);
        zoo.giveHomelessPet(pet);
        zoo.giveHomelessPet(pet);

        String actual = zoo.getPetNames(); //

        assertThat(expected).isEqualTo(actual);
    }
    //wielokrotnie zwrazca różne wartości
    @Test
    public void getPetName_mockedPetRerturnsTofikAndFafik_TofikFafik(){
        String expected = "Tofik, Fafik";
        Pet pet = mock(Pet.class);
        when(pet.getName()).thenReturn("Tofik").thenReturn("Fafik");
        Zoo zoo = new Zoo();
        zoo.giveHomelessPet(pet);
        zoo.giveHomelessPet(pet);

        String actual = zoo.getPetNames();

        assertThat(expected).isEqualTo(actual);
    }
}
