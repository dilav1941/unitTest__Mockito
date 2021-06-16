import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;

public class Test_GeoServiceImpl {
    @Test
            void TestGetLocationIP(){
        GeoService geoService = new ru.netology.geo.GeoServiceImpl ();
        Location expectlocation = new Location ("Moskow", Country.RUSSIA, "Lenina", 15);

        Location location = geoService.byIp ("172.");

        Assertions.assertEquals (expectlocation.getCountry (), location.getCountry ());
    }

}
