package com.fayaaz.ali;



import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FirstTest {

    @Test
    public void shouldRunFirstTest() {

        List mock = mock(List.class);
        mock.add("one");
        verify(mock).add(any());



    }

}
