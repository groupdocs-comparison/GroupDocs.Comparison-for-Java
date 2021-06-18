package com.groupdocs.ui.comparison;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComparisonControllerTest {
    MockMvc mvc;
    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    ComparisonController controller;
    @Before
    public void setUp() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        this.mvc = standaloneSetup(this.controller).setViewResolvers(viewResolver).build();
    }
    @Test
    public void getView()  throws Exception {
        mvc.perform(get("/comparison")).andExpect(status().isOk()).andExpect(view().name("comparison"));
    }

    public void loadFileTree() {
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