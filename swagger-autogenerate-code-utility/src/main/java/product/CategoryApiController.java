package product;

import io.swagger.model.Category;
import io.swagger.model.Categoryresponse;
import io.swagger.model.Error;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-05T14:21:34.873+05:30")

@Controller
public class CategoryApiController implements CategoryApi {

    private static final Logger log = LoggerFactory.getLogger(CategoryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CategoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> categoryByCategoryIdDELETE(@ApiParam(value = "",required=true) @PathVariable("categoryId") String categoryId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Category> categoryByCategoryIdGET(@ApiParam(value = "",required=true) @PathVariable("categoryId") String categoryId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Category>(objectMapper.readValue("{  \"message\" : \"Forbidden\",  \"success\" : false,  \"data\" : {    \"productId\" : 123434,    \"productShortName\" : \"PTMS_FREE\",    \"productLongName\" : \"PTMS_FREE_MONTHLY_SUBSCRIPTION\",    \"productDescription\" : \"PTMS service offered for free for a month from the date of subscription/registration\",    \"productSku\" : \"PTMS_FREE_1_MONTH\",    \"productCategoryId\" : 1,    \"productUnitPrice\" : 0,    \"productAvailable\" : \"Y\",    \"productTypeId\" : 1,    \"productImagesId\" : 123  },  \"errorCode\" : -1}", Category.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Category>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Categoryresponse> categoryByCategoryIdPOST(@ApiParam(value = "",required=true) @PathVariable("categoryId") String categoryId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Category body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Categoryresponse>(objectMapper.readValue("{  \"success\" : true,  \"message\" : \"The Category has been created successfully\",  \"data\" : {    \"id\" : 123  },  \"error_code\" : 400}", Categoryresponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Categoryresponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Categoryresponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Category> categoryByCategoryIdPUT(@ApiParam(value = "",required=true) @PathVariable("categoryId") String categoryId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Category body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Category>(objectMapper.readValue("{  \"categoryName\" : \"categoryName\",  \"categoryId\" : 0,  \"categoryDescription\" : \"categoryDescription\"}", Category.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Category>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Category>> categoryGET(@ApiParam(value = "Get payment info for a given Tenant Name") @Valid @RequestParam(value = "categoryName", required = false) String categoryName) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Category>>(objectMapper.readValue("[ {  \"categoryName\" : \"categoryName\",  \"categoryId\" : 0,  \"categoryDescription\" : \"categoryDescription\"}, {  \"categoryName\" : \"categoryName\",  \"categoryId\" : 0,  \"categoryDescription\" : \"categoryDescription\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Category>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Category>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Categoryresponse> categoryPOST(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Category body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Categoryresponse>(objectMapper.readValue("{  \"success\" : true,  \"message\" : \"The Category has been created successfully\",  \"data\" : {    \"id\" : 123  },  \"error_code\" : 400}", Categoryresponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Categoryresponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Categoryresponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
