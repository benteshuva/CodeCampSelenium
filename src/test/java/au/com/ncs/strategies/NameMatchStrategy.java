package au.com.ncs.strategies;

import au.com.ncs.models.Planets;

public class NameMatchStrategy implements MatchStrategyInterface {
    private String name;
    public NameMatchStrategy(String name) {
        this.name = name;
    }
    @Override
    public boolean match(Planets planet ) {
        return planet.getName().equalsIgnoreCase(name);
    }
}
