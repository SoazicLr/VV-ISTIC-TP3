package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TLSSocketFactoryTestMocks {

    @InjectMocks
    private TLSSocketFactory tlsSocketFactory;
    @Mock
    private SSLSocket socket;

    String[] supported;
    String[] enable;
    String[] enabling;

    @BeforeEach
    void setUp(){
        enable = shuffle(new String[]{"SSLv3", "TLSv1"});
        supported = shuffle(new String[]{"TLSv1.2"});
        enabling = shuffle(new String[]{"SSLv3", "TLSv1.2", "TLSv1"});

    }

    @Test
    void testPrepareSocketWithNull(){
        when(socket.getSupportedProtocols()).thenReturn(null);
        when(socket.getEnabledProtocols()).thenReturn(null);

        tlsSocketFactory.prepareSocket(socket);

        verify(socket).getSupportedProtocols();
        verify(socket).getEnabledProtocols();
    }

    @Test
    void testPrepareSocket(){
        when(socket.getEnabledProtocols()).thenReturn(enable);
        when(socket.getSupportedProtocols()).thenReturn(supported);

        tlsSocketFactory.prepareSocket(socket);

        verify(socket).getEnabledProtocols();
        verify(socket).getSupportedProtocols();
        verify(socket).setEnabledProtocols(any());
    }


    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}