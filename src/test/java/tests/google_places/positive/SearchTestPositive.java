package tests.google_places.positive;

import api.models.google_places.GooglePlacesModel;
import base.TestBase;
import io.restassured.http.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constants.constants.API_TOKEN;

public class SearchTestPositive extends TestBase {

    @Test(description = "search some object", dataProvider = "SearchText")
    public void  searchPlaceWithText(String key,String input,String inputtype){
        GooglePlacesModel.RequestModel requestModel =GooglePlacesModel.RequestModel.builder()
             .key(key)
             .input(input)
             .inputtype(inputtype)
             .build();
        apiManager.getGooglePlacesModel().search(requestModel, Method.GET,200);
    }

    @DataProvider
    public Object[] [] SearchText(){
        return new Object[][]{
         {API_TOKEN,"New York","textquery"}
        };
    }

}
