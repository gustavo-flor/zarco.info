package com.github.gustavoflor.zarco.repository;

import com.github.gustavoflor.zarco.entity.Line;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LineRepositoryImpl implements LineRepository {
    private static final Faker FAKER = new Faker();
    private static final String LINE_NAME_TEMPLATE = "%s / %s";

    @Override
    public List<Line> findAll() {
        return List.of(
            new Line(1001L, String.format(LINE_NAME_TEMPLATE, FAKER.address().streetName(), FAKER.address().streetName())),
            new Line(3002L, String.format(LINE_NAME_TEMPLATE, FAKER.address().streetName(), FAKER.address().streetName())),
            new Line(3003L, String.format(LINE_NAME_TEMPLATE, FAKER.address().streetName(), FAKER.address().streetName())),
            new Line(3004L, String.format(LINE_NAME_TEMPLATE, FAKER.address().streetName(), FAKER.address().streetName())),
            new Line(3005L, String.format(LINE_NAME_TEMPLATE, FAKER.address().streetName(), FAKER.address().streetName())),
            new Line(3006L, String.format(LINE_NAME_TEMPLATE, FAKER.address().streetName(), FAKER.address().streetName())),
            new Line(4007L, String.format(LINE_NAME_TEMPLATE, FAKER.address().streetName(), FAKER.address().streetName())),
            new Line(4008L, String.format(LINE_NAME_TEMPLATE, FAKER.address().streetName(), FAKER.address().streetName())),
            new Line(5009L, String.format(LINE_NAME_TEMPLATE, FAKER.address().streetName(), FAKER.address().streetName())),
            new Line(6001L, String.format(LINE_NAME_TEMPLATE, FAKER.address().streetName(), FAKER.address().streetName()))
                      );
    }
}
