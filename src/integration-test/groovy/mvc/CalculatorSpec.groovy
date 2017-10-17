package mvc

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import spock.lang.Unroll

import javax.xml.transform.Result

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class CalculatorSpec extends GebSpec {

    @Unroll
    void "Basic calculation: with en #enInput und exam #examInput should give result #result"() {
        when:
            go '/static/GradeCalculator.html'
        then:
        	title == "Grade Calculator"

        when: "set valid input"
            $("form").en   = enInput
            $("form").exam = examInput
            $("input", type: "submit").click()

        then: "Result Page is displayed"
            title == "Average"
            $("output").text() == result

        where:
            enInput | examInput | result
            4.0     | 5.0       | "4.5"
            5.0     | 4.0       | "4.5"
            1.0     | 6.0       | "3.5"
            6.0     | 6.0       | "6.0"



    }
}
