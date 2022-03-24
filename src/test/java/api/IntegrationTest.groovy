package api

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class IntegrationTest extends Specification {

    def "ケース: #station / #train / #seat / 大人片道1枚"() {
        when:
        def actualFare = getFareExample(station, train, seat)

        then:
        actualFare == expectedFare

        where:
        station | train | seat  || expectedFare
        "新大阪"   | "ひかり" | "指定席" || 14400
        "新大阪"   | "ひかり" | "自由席" || 13870
        "新大阪"   | "のぞみ" | "指定席" || 14720
        "新大阪"   | "のぞみ" | "自由席" || 14190
        "姫路"    | "ひかり" | "指定席" || 15930
        "姫路"    | "ひかり" | "自由席" || 15400
        "姫路"    | "のぞみ" | "指定席" || 16460
        "姫路"    | "のぞみ" | "自由席" || 15930
    }

    private static int getFareExample(String station, String train, String seat) {
        int fare = 0
        switch (station) {
            case "新大阪": fare += 8910 + 5490
                if (train == "のぞみ") fare += 320
                break
            case "姫路": fare += 10010 + 5920
                if (train == "のぞみ") fare += 530
                break
        }
        if (seat == "自由席") {
            fare -= 530
        }
        return fare
    }
}
