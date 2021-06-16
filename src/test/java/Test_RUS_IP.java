import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class Test_RUS_IP {
    @Test
    void Test_RUS_IP (){
        Map<String, String> headers = new HashMap<String, String> ();
        headers.put (MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        String expectMessage = "Добро пожаловать!";

        GeoService geoService = Mockito.mock (GeoServiceImpl.class);
        when(geoService.byIp ("172.123.12.19"))
                .thenReturn (new Location ("Moskow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localServiceRU = Mockito.mock (LocalizationServiceImpl.class);
        Mockito.when(localServiceRU.locale (Country.RUSSIA))
                .thenReturn ("Добро пожаловать!");

        MessageSender messageSender = new MessageSenderImpl (geoService, localServiceRU);
        String message = messageSender.send (headers);
        Assertions.assertEquals (expectMessage, message);
    }
}
