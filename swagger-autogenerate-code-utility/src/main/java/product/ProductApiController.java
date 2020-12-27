package product;

import io.swagger.model.Error;
import io.swagger.model.Product;
import io.swagger.model.Productresponse1;
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
public class ProductApiController implements ProductApi {

    private static final Logger log = LoggerFactory.getLogger(ProductApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> productByProductIdDELETE(@ApiParam(value = "",required=true) @PathVariable("productId") String productId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Product> productByProductIdGET(@ApiParam(value = "",required=true) @PathVariable("productId") String productId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{  \"message\" : \"Forbidden\",  \"success\" : false,  \"data\" : {    \"productId\" : 123434,    \"productShortName\" : \"PTMS_FREE\",    \"productLongName\" : \"PTMS_FREE_MONTHLY_SUBSCRIPTION\",    \"productDescription\" : \"PTMS service offered for free for a month from the date of subscription/registration\",    \"productSku\" : \"PTMS_FREE_1_MONTH\",    \"productCategoryId\" : 1,    \"productUnitPrice\" : 0,    \"productAvailable\" : \"Y\",    \"productTypeId\" : 1,    \"productImagesId\" : 123  },  \"errorCode\" : -1}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Productresponse1> productByProductIdPOST(@ApiParam(value = "",required=true) @PathVariable("productId") String productId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Productresponse1>(objectMapper.readValue("{  \"success\" : true,  \"message\" : \"The Product has been created successfully\",  \"data\" : {    \"id\" : 123  },  \"error_code\" : 400}", Productresponse1.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Productresponse1>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Productresponse1>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Product> productByProductIdPUT(@ApiParam(value = "",required=true) @PathVariable("productId") String productId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{  \"productLongName\" : \"productLongName\",  \"productAvailable\" : \"productAvailable\",  \"productImagesId\" : \"productImagesId\",  \"productSku\" : \"productSku\",  \"productCategoryId\" : 6,  \"productId\" : 0,  \"productUnitPrice\" : 1.4658129805029452,  \"productShortName\" : \"productShortName\",  \"productDescription\" : \"productDescription\",  \"productTypeId\" : 5}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Product>> productGET(@ApiParam(value = "Get List of Tenant Info based on a given Tenant Name") @Valid @RequestParam(value = "productName", required = false) String productName,@ApiParam(value = "Get List of Tenant Info based on a given Tenant Email") @Valid @RequestParam(value = "productCategory", required = false) String productCategory) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Product>>(objectMapper.readValue("[ {  \"productLongName\" : \"productLongName\",  \"productAvailable\" : \"productAvailable\",  \"productImagesId\" : \"productImagesId\",  \"productSku\" : \"productSku\",  \"productCategoryId\" : 6,  \"productId\" : 0,  \"productUnitPrice\" : 1.4658129805029452,  \"productShortName\" : \"productShortName\",  \"productDescription\" : \"productDescription\",  \"productTypeId\" : 5}, {  \"productLongName\" : \"productLongName\",  \"productAvailable\" : \"productAvailable\",  \"productImagesId\" : \"productImagesId\",  \"productSku\" : \"productSku\",  \"productCategoryId\" : 6,  \"productId\" : 0,  \"productUnitPrice\" : 1.4658129805029452,  \"productShortName\" : \"productShortName\",  \"productDescription\" : \"productDescription\",  \"productTypeId\" : 5} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Product>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Productresponse1> productPOST(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Productresponse1>(objectMapper.readValue("{  \"success\" : true,  \"message\" : \"The Product has been created successfully\",  \"data\" : {    \"id\" : 123  },  \"error_code\" : 400}", Productresponse1.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Productresponse1>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Productresponse1>(HttpStatus.NOT_IMPLEMENTED);
    }

}
