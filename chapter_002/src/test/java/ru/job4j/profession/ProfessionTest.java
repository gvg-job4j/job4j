package ru.job4j.profession;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 17.06.2018.
 */
public class ProfessionTest {
    @Test
    public void whenSetProfessionDoctorThenDoctor(){
        Doctor doc = new Doctor();
        doc.setProfession("Doctor");
        String result = doc.getProfession();
        Assert.assertThat(result, is("Doctor"));
    }
}
