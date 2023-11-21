package com.example.cashcard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

@JsonTest
public class CashCardJsonTest {

    @Autowired
    private JacksonTester<CashCard> json;

    @Test
    void cashCardSerializationTest() throws IOException {
        CashCard cashCard = new CashCard(99L, 123.45);

        Assertions.assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
        Assertions.assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
        Assertions.assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
        Assertions.assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
        Assertions.assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
    }

    @Test
    void cashCardDeserializationTest() throws IOException {
        String expected = """
                {
                    "id":99,
                    "amount":123.45
                }
                """;
        Assertions.assertThat(json.parse(expected)).isEqualTo(new CashCard(99L, 123.45));
        Assertions.assertThat(json.parseObject(expected).id()).isEqualTo(99);
        Assertions.assertThat(json.parseObject(expected).amount()).isEqualTo(123.45);
    }
}
