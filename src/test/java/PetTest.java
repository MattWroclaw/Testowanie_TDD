import org.junit.*;

import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PetTest {
    private static Pet pet;
    @BeforeClass
    // jak ciągle się powtarza   Pet mockedPet = mock(Pet.class);
//to można zrobić BeforeClass
    public static void setup(){
        pet= mock(Pet.class);
        System.out.println("Before class");
    }


    // musimy po sobie posprzątać i w AfterClass definiujemy nasze czyszczenie
    @AfterClass
    public static void cleanup(){
        pet =null;
        System.out.println("AfterClass");
    }



    @Test
    public void getName_mockedPet_callVerification(){
        Pet mockedPet = mock(Pet.class); //tutaj sobie zostawiam dla przykładu

        mockedPet.getName();

        verify(mockedPet).getName();
        System.out.println("Test name");

    }

    @Test
    public void setName_mockedPet_callVerification(){
        //usunąłem Pet mockedPet = mock(Pet.class);
        // bo jest BeforeClass  pet= mock(Pet.class);
        pet.setName("fafik");

        verify(pet).setName("fafik");
        System.out.println("test name");
    }

    @Before
    public void setupTest(){
        System.out.println("setup test - Before");
    }
    @After
    public void cleanupTest(){
        System.out.println("cleanup test- After");
    }

    @Test
    public void getName_mockedPetWhichReturnsFafikName_ExpFafik(){
        String expected  ="fafik";
        when(pet.getName()).thenReturn("fafik");

        String actal = pet.getName();

        assertThat(expected).isEqualTo(actal);
    }

}
