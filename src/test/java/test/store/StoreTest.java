package test.store;


import Annotations.FrameWorkAnnotation;
import Extent.BaseTest;
import Extent.ExtentLogger;
import FrameWorkConstants.FolderPathConstants;
import FrameWorkConstants.ReadAndWriteJsonConstants;
import FrameWorkConstants.RoutesStoreConstants;
import Handlers.RequestHandler;
import Handlers.ResponseHandler;
import Helpers.StoreHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.store.pojo.store.Store;

public class StoreTest extends BaseTest {

    public static Logger logger;

    @FrameWorkAnnotation(author = "illiyanna", category = "smoke")
    @Test(priority = 1)
    public static void testPlaceAnOrderForPet() throws JsonProcessingException {
        logger.debug("creating the account ");
        Response response = RequestHandler.sendPostRequest(RoutesStoreConstants.base_Url + RoutesStoreConstants.post_Endpoint, StoreHelper.storeData());


        ReadAndWriteJsonConstants.storeStringJson(FolderPathConstants.getResponseJsonPath() + "resonse", response);
        //created an ResponseHandler object and send the response to the constructor
        ResponseHandler responseHandler = new ResponseHandler(response);
        System.out.println(responseHandler.getResponseBody());
        System.out.println(responseHandler.getstatusCode());
        Store storeObject = responseHandler.getResponseObject(Store.class);
        Assert.assertEquals(storeObject.getId(), 1);
        Assert.assertEquals(storeObject.getPetId(), 10);
        Assert.assertEquals(storeObject.getQuantity(), 4);
        ExtentLogger.pass("yes passed");
        ExtentLogger.logResponse(response.asPrettyString());
        logger.debug(" user is created the account ");
    }

    @BeforeClass
    public void setup() {

        logger = LogManager.getLogger(this.getClass());
    }

    @FrameWorkAnnotation(author = {"illiyanna", "ravi"}, category = {"smoke", "Regreesion"})
    @Test(priority = 2)
    public void testGetThestoreDetails() throws JsonProcessingException {
        logger.debug("update the account ");
        Response response = RequestHandler.sendGetRequest(RoutesStoreConstants.base_Url + RoutesStoreConstants.get_Endpoint);

        ReadAndWriteJsonConstants.storeStringJson(FolderPathConstants.getResponseJsonPath() + "resonse", response);
        ResponseHandler responseHandler = new ResponseHandler(response);
        System.out.println(responseHandler.getResponseBody());
        System.out.println(responseHandler.getstatusCode());
        Store storeObject = responseHandler.getResponseObject(Store.class);
        Assert.assertEquals(storeObject.getId(), 1);
        Assert.assertEquals(storeObject.getPetId(), 10);
        Assert.assertEquals(storeObject.getQuantity(), 4);
        ExtentLogger.pass("yes passed");
        logger.debug(" user updated the account ");
    }

    @FrameWorkAnnotation
    @Test(priority = 3)

    public void testDeleteTheStore() {
        logger.debug("delete the account ");
        Response res = RequestHandler.sendDeleteRequest(RoutesStoreConstants.base_Url + RoutesStoreConstants.delete_Endpoint);
        System.out.println(res.body().asPrettyString());

        ExtentLogger.pass("yes passed");
        ReadAndWriteJsonConstants.storeStringJson(FolderPathConstants.getResponseJsonPath() + "resonse", res);
        logger.debug(" user deleted the account ");
    }


}
