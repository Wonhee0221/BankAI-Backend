package com.hana.bankai.domain.admin.controller;

import com.hana.bankai.domain.admin.dto.AdminResponseDto;
import com.hana.bankai.domain.admin.service.AdminService;
import com.hana.bankai.global.common.response.ApiResponse;
import com.hana.bankai.domain.product.entity.ProdType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/line-chart")
    public Map<String, Map<Integer, Integer>> getLineChartData(@RequestParam("year") int year) {
        return adminService.getLineChartData(year);
    }

    @GetMapping("/bar-chart")
    public Map<ProdType, List<AdminResponseDto.ProductJoinCntByAgeGroup>> getBarChartData() {
        return adminService.getBarChartData();
    }

    @GetMapping("/piechart")
    public ApiResponse<List<Integer>> getProdJoinRate() {
        return adminService.getProdJoinRate();
    }


}
