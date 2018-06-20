package ru.job4j.profession;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 17.06.2018.
 */
public class DoctorTest {
    @Test
    public void whenSetNameDoctorThenDoctor() {
        Doctor doc = new Doctor();
        doc.setName("Doctor");
        String result = doc.getName();
        Assert.assertThat(result, is("Doctor"));
    }
}
