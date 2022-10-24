package com.medi._420556intra.service;

import com.medi._420556intra.service.implementation.MathServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MathServiceTest {
    @InjectMocks
    MathServiceImpl mathService;

    @Test
    void addHappyDay(){
        //Arrange

        int expected = 11;

        //Act

        int actual = mathService.add(7,4);


        //Assert

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void addNegativeNumber(){
        //Arrange

        int expected = -3;

        //Act

        int actual = mathService.add(-7,4);


        //Assert

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void addNegativeNumbers(){
        //Arrange

        int expected = -15;

        //Act

        int actual = mathService.add(-9,-6);


        //Assert

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void addZero(){
        //Arrange

        int expected = 7;

        //Act

        int actual = mathService.add(7,0);


        //Assert

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void subtractHappyDay(){
        //Arrange

        int expected = 3;

        //Act

        int actual = mathService.subtract(7,4);


        //Assert

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void subtractNegativeNumber(){
        //Arrange

        int expected = -11;

        //Act

        int actual = mathService.subtract(-7,4);


        //Assert

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void subtractNegativeNumbers(){
        //Arrange

        int expected = -3;

        //Act

        int actual = mathService.subtract(-9,-6);


        //Assert

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void subtractZero(){
        //Arrange

        int expected = 7;

        //Act

        int actual = mathService.subtract(7,0);


        //Assert

        assertThat(actual).isEqualTo(expected);

    }
}
