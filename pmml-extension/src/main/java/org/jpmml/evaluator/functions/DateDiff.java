/*
 * Copyright (c) 2015 Ben Auffarth
 */
package org.jpmml.evaluator.functions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.dmg.pmml.DataType;
import org.dmg.pmml.OpType;
import org.joda.time.*;
import org.jpmml.evaluator.FieldValue;
import org.jpmml.evaluator.FieldValueUtil;

/**
 * <p>
 * A Java UDF for calculating date differences.
 * </p>
/**
 * Created by benjamin on 12/01/2016.
 */
public class DateDiff extends AbstractFunction {

    public DateDiff(){
        this(DateDiff.class.getName());
    }

    public DateDiff(String name){
        super(name);
    }

    public LocalDateTime convert2Date(String datestr){
        LocalDateTime date = null;
        if(datestr.toLowerCase().equals("now()")) {
            date = LocalDateTime.now();
        } else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            date = LocalDateTime.parse(datestr, formatter);
        }
        return date;
    }

    @Override
    public FieldValue evaluate(List<FieldValue> arguments){
        checkArguments(arguments, 2);

        String datestr1 = FieldValueUtil.getValue(String.class, arguments.get(0));
        String datestr2 = FieldValueUtil.getValue(String.class, arguments.get(1));

        LocalDateTime date1 = convert2Date(datestr1);
        LocalDateTime date2 = convert2Date(datestr2);

        long result = evaluate(date1, date2);
        Integer i = (int) result;

        return FieldValueUtil.create(DataType.INTEGER, OpType.CONTINUOUS, result);
    }

    static
    private long evaluate(LocalDateTime date1, LocalDateTime date2){
        long result = ChronoUnit.SECONDS.between(date1, date2); // should be a long really, but long not DMG defined
        return result;
    }
}