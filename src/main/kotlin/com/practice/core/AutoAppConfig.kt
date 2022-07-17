package com.practice.core

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    excludeFilters = [ //AppConfig를 제외하기 위한 설정. 보통은 설정하지 않음
        Filter(
            type = FilterType.ANNOTATION,
            classes = arrayOf(Configuration::class)
        )
    ]
)
class AutoAppConfig