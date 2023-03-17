import org.bugred.ShopBugred;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShopBugredTest {
    ShopBugred shopBugred = new ShopBugred();

    @Test
    @DisplayName("Создание товара")
    public void testCreateItem() throws ParseException {
        shopBugred.CreateItem("Rubweashka", "Верхняя одежда", "Зимняя одежда",
                "BLUE", "48", 44, "Shops");
    }

    @Test
    @DisplayName("Обновление товара")
    public void testUpdateItem() {

        shopBugred.updateItem();
    }

    @Test
    @DisplayName("Обновление картинки")
    public void testUpdatePhoto() {
        shopBugred.updatePhoto();
    }

    @Test
    @DisplayName("Просмотр товара")
    public void testGetItem() {
        shopBugred.getInfoItem();
    }

    @Test
    @DisplayName("удаление товара")
    public void testDeleteItem() {
        shopBugred.getDeleteItem();
    }

    @Test
    @DisplayName("удаление товара")
    public void testcheckDeleteItem() {
        shopBugred.checkgetInfoItem();
    }

    @Test
    @DisplayName("запрос из бд по товару")
    public void testdataBaseInfoItem(){
        shopBugred.dataBaseInfoItem();
    }
}