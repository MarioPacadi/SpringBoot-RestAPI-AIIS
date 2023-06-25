package hr.algebra.dogsapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class DogsControllerTest extends BaseControllerTest {

//    @Test
//    void getAll() throws Exception {
//        mockMvc.perform(
//                get("/hardware")
//                        .header(HttpHeaders.AUTHORIZATION, getAdminAuthorizationHeader())
//                        .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(content().encoding(StandardCharsets.UTF_8))
//                .andExpect(jsonPath("$", hasSize(5)));
//    }
//
//    @Test
//    void getByCode() throws Exception {
//        mockMvc.perform(
//                get("/hardware/1234561")
//                        .header(HttpHeaders.AUTHORIZATION, getAdminAuthorizationHeader())
//                        .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(content().encoding(StandardCharsets.UTF_8))
//                .andExpect(jsonPath("$.code").value("1234561"))
//                .andExpect(jsonPath("$.name").value("Asus TUF RTX 3080"))
//                .andExpect(jsonPath("$.price").value(1599.00));
//    }
//
//    @Test
//    @Transactional
//    void save_asAdminUser() throws Exception {
//        final String TEST_CODE = "6543210";
//        final String TEST_NAME = "Asus ROG Strix RTX 4090 Ti";
//        final String TEST_TYPE =  Type.GPU.toString();
//        final long TEST_STOCK = 0;
//        final BigDecimal TEST_PRICE = BigDecimal.valueOf(1599.00);
//
//
//        Map<String,Object> body = new HashMap<>();
//        body.put("code", TEST_CODE);
//        body.put("name", TEST_NAME);
//        body.put("type", TEST_TYPE);
//        body.put("stock", TEST_STOCK);
//        body.put("price", TEST_PRICE);
//
//        mockMvc.perform(
//                        post("/hardware")
//                                .header(HttpHeaders.AUTHORIZATION, getAdminAuthorizationHeader())
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(objectMapper.writeValueAsString(body))
//                )
//                .andExpect(status().isCreated())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(content().encoding(StandardCharsets.UTF_8))
//                .andExpect(jsonPath("$.code").value(TEST_CODE))
//                .andExpect(jsonPath("$.name").value(TEST_NAME))
//                .andExpect(jsonPath("$.price").value(TEST_PRICE));
//    }
//
//    @Test
//    void save_asRegularUser() throws Exception {
//        final String TEST_CODE = "6543210";
//        final String TEST_NAME = "Asus ROG Strix RTX 4090 Ti";
//        final String TEST_TYPE =  Type.GPU.toString();
//        final long TEST_STOCK = 0;
//        final BigDecimal TEST_PRICE = BigDecimal.valueOf(1599.00);
//
//
//        Map<String,Object> body = new HashMap<>();
//        body.put("code", TEST_CODE);
//        body.put("name", TEST_NAME);
//        body.put("type", TEST_TYPE);
//        body.put("stock", TEST_STOCK);
//        body.put("price", TEST_PRICE);
//
//        mockMvc.perform(
//                        post("/hardware")
//                                .header(HttpHeaders.AUTHORIZATION, getUserAuthorizationHeader())
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(objectMapper.writeValueAsString(body))
//                )
//                .andExpect(status().isForbidden());
//    }
//
//    @Test
//    @Transactional
//    void update_asAdminUser() throws Exception {
//        final String TEST_NAME = "Asus TUF RTX 3080";
//        final String TEST_TYPE =  Type.GPU.toString();
//        final long TEST_STOCK = 30;
//        final BigDecimal TEST_PRICE = BigDecimal.valueOf(999.99);
//
//        Map<String,Object> body = new HashMap<>();
//        body.put("name", TEST_NAME);
//        body.put("type", TEST_TYPE);
//        body.put("stock", TEST_STOCK);
//        body.put("price", TEST_PRICE);
//
//        mockMvc.perform(
//                        put("/hardware/1234561")
//                                .header(HttpHeaders.AUTHORIZATION, getAdminAuthorizationHeader())
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(objectMapper.writeValueAsString(body))
//                )
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(content().encoding(StandardCharsets.UTF_8))
//                .andExpect(jsonPath("$.code").value("1234561"))
//                .andExpect(jsonPath("$.name").value(TEST_NAME))
//                .andExpect(jsonPath("$.price").value(TEST_PRICE));
//    }
//
//    @Test
//    void update_asRegularUser() throws Exception {
//        final String TEST_NAME = "Asus TUF RTX 3080";
//        final String TEST_TYPE =  Type.GPU.toString();
//        final long TEST_STOCK = 30;
//        final BigDecimal TEST_PRICE = BigDecimal.valueOf(999.99);
//
//        Map<String,Object> body = new HashMap<>();
//        body.put("name", TEST_NAME);
//        body.put("type", TEST_TYPE);
//        body.put("stock", TEST_STOCK);
//        body.put("price", TEST_PRICE);
//
//        mockMvc.perform(
//                        put("/hardware/1234561")
//                                .header(HttpHeaders.AUTHORIZATION, getUserAuthorizationHeader())
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(objectMapper.writeValueAsString(body))
//                )
//                .andExpect(status().isForbidden());
//    }
//
//    @Test
//    @Transactional
//    void delete_asAdminUser() throws Exception {
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete("/hardware/1234561")
//                                .header(HttpHeaders.AUTHORIZATION, getAdminAuthorizationHeader())
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    void delete_asRegularUser() throws Exception {
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete("/hardware/1234561")
//                                .header(HttpHeaders.AUTHORIZATION, getUserAuthorizationHeader())
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().isForbidden());
//    }
}
