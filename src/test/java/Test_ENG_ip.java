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

public class Test_ENG_ip {
    @Test
    void Test_ENG_IP(){
        Map<String, String> headers = new HashMap<String, String> ();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        String expectMessage = "Welcome!";

        GeoService geoService = Mockito.mock (GeoServiceImpl.class);
        Mockito.when (geoService.byIp ("96.44.183.149"))
                .thenReturn(new Location ("New York", Country.USA, " 10th Avenue", 32));

        LocalizationService localizationService = Mockito.mock (LocalizationServiceImpl.class);
        Mockito.when (localizationService.locale (Country.USA))
                .thenReturn ("Welcome!");

        MessageSender messageSender = new MessageSenderImpl (geoService, localizationService);
        String massage = messageSender.send (headers);

        Assertions.assertEquals (expectMessage, massage);
    }
}
