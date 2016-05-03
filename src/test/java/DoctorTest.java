import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class DoctorTest{

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/doctors_office_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteDoctors = "DELETE FROM doctors *;";
      con.createQuery(deleteDoctors).executeUpdate();
    }
  }

  @Test
  public void doctor_instantiates_newDoctor(){
    Doctor testDoctor = new Doctor("Carlos", "Gino");
    assertTrue(testDoctor instanceof Doctor);
  }

  @Test
  public void doctor_instantiates_getDoctorName(){
    Doctor testDoctor = new Doctor("Carlos", "Gino");
    assertEquals("Carlos" , testDoctor.getName());
  }

  @Test
  public void doctor_instantiates_getDoctorSpecialty(){
    Doctor testDoctor = new Doctor("Carlos", "Gino");
    assertEquals("Gino", testDoctor.getSpecialty());
  }

  @Test
  public void doctor_saveDoctorIntoDatabase(){
    Doctor testDoctor = new Doctor("Carlos", "Gino");
    testDoctor.save();
    assertEquals(Doctor.all().size(), 1);
  }

  @Test
  public void doctor_TestIfDoctorInstancesAreTheSame(){
    Doctor testDoctor = new Doctor("Carlos", "Gino");
    testDoctor.save();
    assertTrue(Doctor.all().get(0).equals(testDoctor));
  }

  @Test
  public void doctor_instantiates_getDoctorId(){
    Doctor testDoctor = new Doctor("Carlos", "Gino");
    testDoctor.save();
    Doctor databaseDoctor = Doctor.all().get(0);
    assertEquals(testDoctor.getId(), databaseDoctor.getId());
  }
  @Test
  public void doctor_instantiates_findDoctorById(){
    Doctor testDoctor = new Doctor("Carlos", "Gino");
    testDoctor.save();
    Doctor databaseDoctor = Doctor.find(testDoctor.getId());
    assertTrue(testDoctor.equals(databaseDoctor));
  }







}
