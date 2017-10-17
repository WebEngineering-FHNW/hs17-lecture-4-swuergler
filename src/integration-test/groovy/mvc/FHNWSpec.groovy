package mvc

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class FHNWSpec extends GebSpec {

    void "test home is there"() {
        when:"The home page is visited"
            go 'https://www.fhnw.ch/de/startseite'
        then:"The title of the page"
        	title == "FHNW — Deutsch"  // Attention the - is a dash
            title.startsWith("FHNW")
            $("*", text: containsWord("Studium")).size() > 0
    }

}
