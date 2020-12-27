/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.17).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.proarchs.notification.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proarchs.notification.model.Emailverification;
import com.proarchs.notification.model.Emailverificationresponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-27T03:25:09.277Z")

@Api(value = "emailverification", description = "the emailverification API")
@RequestMapping(value = "/pnms")
public interface EmailverificationApi {

	@ApiOperation(value = "EmailverificationEmailverificationcheck_GET", nickname = "emailverificationEmailverificationcheckGET", notes = "", tags={ "emailverification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "") })
    @RequestMapping(value = "/emailverification/{verificationId}/emailverificationcheck",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<String> emailverificationEmailverificationcheckGET(@ApiParam(value = "",required=true) @PathVariable("verificationId") String verificationId,@NotNull @ApiParam(value = "This is the Verification Code", required = true) @Valid @RequestParam(value = "code", required = true) String code);
	
    @ApiOperation(value = "Emailverification_GET", nickname = "emailverificationGET", notes = "Get a list of Emailverification", response = Emailverification.class, responseContainer = "List", tags={ "emailverification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Emailverification.class, responseContainer = "List") })
    @RequestMapping(value = "/emailverification",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Emailverification>> emailverificationGET();


    @ApiOperation(value = "Emailverification_POST", nickname = "emailverificationPOST", notes = "Add a new Emailverification", response = Emailverificationresponse.class, tags={ "emailverification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "", response = Emailverificationresponse.class) })
    @RequestMapping(value = "/emailverification",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<String> emailverificationPOST(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Emailverification body);

}
