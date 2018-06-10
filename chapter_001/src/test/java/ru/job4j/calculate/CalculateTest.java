package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/*
*Test for Calculate
*@author Valeriy Gyrievskikh
*@since 10.06.2018
*/
public class CalculateTest {
	
	/**
	*Test echo
	*/
	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Valeriy";
		String expect = "Echo, echo, echo : Valeriy";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}