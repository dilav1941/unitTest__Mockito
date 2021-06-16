import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class Test_Location_servise {
    @Test
    void test_GetByCountry(){
        String expectLocation = "Добро пожаловать";
        LocalizationService localizationService = new LocalizationServiceImpl ();
        String locale = localizationService.locale(Country.RUSSIA);

        Assertions.assertEquals (expectLocation, locale);
    }
}
