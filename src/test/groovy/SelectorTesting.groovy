import Game.BasicClasses.Position
import Game.Selector.Selector
import spock.lang.Specification

class SelectorTesting extends Specification{
    def "testing move()"(){
        given:
        Selector selector = new Selector(6)

        when:
        def assertion = selector.move(1,-2)

        then:
        assertion
        new Position(4,4) == selector.getPosition()
    }
}
