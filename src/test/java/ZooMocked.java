import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

// ########## ZADANIE DOMOWE########
public class ZooMocked {
//Pkt 1.
    @Test
    // sprawdzam, czy została wywołana metoda sleep()
    public void sleep_verification(){
        //mocked creation
        Pet mockedPet = mock(Pet.class);

        mockedPet.sleep(8);

        verify(mockedPet).sleep(8);

    }
    // w ramach treningu robię sobie Beforeclass
    private static Pet mockedPet;
    @BeforeClass
    public static void setup(){
        mockedPet = mock(Pet.class);
    }
    @Test
    public void feed_Mocked_Verification(){
        //mock creation już jest zrobiony
        //w setup -> mockedPet=mock(Pte.class)

        //wywołanie metody
        mockedPet.feed(5);

        //weryfikacja
        verify(mockedPet).feed(5);
    }
    @Test
    public void getBMI_mocked_verification(){
        //mockedPet jest już zrobiony

        mockedPet.getBMI(); //wywołanie testowanej motody

        verify(mockedPet).getBMI(); //weryfikacja

    }
    //Pkt. 2 Zad Dom
// zwracanie konkretnej wartości po wywołaniu metody
    @Test
    public void getBMI_mocked(){

    when(mockedPet.getBMI()).thenReturn(4);

    assertThat(4).isEqualTo(mockedPet.getBMI());

    }

    //###Sprawdzenie funkcjonaności klasy ZOO###
    @Test
    // dodawnie zwierzątka do ZOO
    public void giveHomelessPet_Mock(){
        Zoo zoo = mock(Zoo.class);
        Pet pet = mock(Pet.class);

        zoo.giveHomelessPet(pet); //wywołanie testowej moetody

        verify(zoo).giveHomelessPet(pet);
    }
    @Test
    public void giveHomelssPt_getPetNames_mockito(){
        Zoo zoo = mock(Zoo.class);
        Pet pet = mock(Pet.class);

        zoo.giveHomelessPet(pet);

        verify(zoo).getPetNames();
    }
    @Test
    //czy metoda getPetName jest wywoływana tyle razy ile zwierząt w zoo
    public void ileGetPetName_mock(){
        List mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.add("one");
        mockedList.add("three");

//        verify(mockedList).add("one");
        verify(mockedList, times(2)).add("one");

    }
    //when(getName)themReturn("Fafik") ?????????
    @Test
    public void whenGetNameThenReturnFAFIK_mocked(){
        Zoo zoo = mock(Zoo.class);
        Pet pet = mock(Pet.class);
        String expected ="Fafik, Tofik, Lolek, Fifi";

        zoo.giveHomelessPet(pet);
        zoo.giveHomelessPet(pet);
        zoo.giveHomelessPet(pet);


        when(pet.getName()).thenReturn(expected);

        String actual = zoo.getPetNames();
        assertThat(expected).isEqualTo("Fafik");
    }
    @Test  //Pkt4,2 nie wiem jak to zrobić????????
    public void dodajPrawdziwe_dodajMock_usun_coNaLiscie(){
        String expected = "Fafik";
        Pet pet1 = mock(Pet.class);
        Pet pet2 = mock(Pet.class);
        Pet pet3 = mock(Pet.class);

        Pet prawdziwy = new Pet();

        Zoo zoo = new Zoo();

        zoo.giveHomelessPet(pet1);
        zoo.giveHomelessPet(pet2);
        zoo.giveHomelessPet(pet3);
        zoo.giveHomelessPet(prawdziwy);

        zoo.takePet(pet3);

        zoo.getPetNames();

    }

}
