package com.groupdocs.ui.comparison.spring;

import com.groupdocs.ui.comparison.spring.common.Application;
import com.groupdocs.ui.comparison.spring.resources.ComparisonResources;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ComparisonControllerTest {
    MockMvc mvc;
    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    ComparisonResources controller;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        this.mvc = standaloneSetup(this.controller).setViewResolvers(viewResolver).build();
    }

    @Test
    public void getView() throws Exception {
        mvc.perform(get("/comparison")).andExpect(status().isOk()).andExpect(view().name("comparison"));
    }

    @Test
    public void loadFileTree() throws Exception {
        mvc.perform(post("/comparison/loadFileTree")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"path\": \"\"}")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(content().string(startsWith("[{\"")))
                .andExpect(content().string(endsWith("}]")))
                .andExpect(content().string(containsString("\"guid\":")))
                .andExpect(content().string(containsString("\"directory\":")))
                .andExpect(content().string(containsString("\"docType\":")))
                .andExpect(content().string(containsString("\"name\":")))
                .andExpect(content().string(containsString("\"size\":")))
        ;
    }

    public void downloadDocument() {
    }

    public void uploadDocument() {
    }

    public void compareWithPaths() {
    }

    public void compareFiles() {
    }

    public void compareWithUrls() {
    }

    public void loadResultPage() {
    }

    public void compare() {
    }

    public void multiCompare() {
    }
}