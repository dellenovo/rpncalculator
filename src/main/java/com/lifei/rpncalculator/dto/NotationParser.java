package com.lifei.rpncalculator.dto;

import com.lifei.rpncalculator.dto.impl.Decimal15Operand;
import com.lifei.rpncalculator.exception.ErrorCode;
import com.lifei.rpncalculator.exception.IllegalNotationException;
import com.lifei.rpncalculator.util.NumberUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NotationParser implements ApplicationContextAware {

    private Map<String, Notation> notationMap = new HashMap<>();

    public Notation parse(String input) throws IllegalNotationException {

        if(NumberUtils.isNumber(input)) {
            return new Decimal15Operand(input);
        }

        Notation result = notationMap.get(input);

        if(result == null) {
            throw new IllegalNotationException(ErrorCode.ILLEGAL_NOTATION, input);
        }

        return result;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //根据接口类型返回相应的所有bean
        Map<String, Notation> map = applicationContext.getBeansOfType(Notation.class);
        for(Notation notation: map.values()) {
            notationMap.put(notation.getText(), notation);
        }
    }
}
