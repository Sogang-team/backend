package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.EducationService;
import com.portfolio.portfolio.application.service.UserEducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;
    private final UserEducationService userEducationService;
}
