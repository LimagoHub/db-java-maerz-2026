import de.dep.Dependency;
import de.dep.impl.DEpendencyImpl2;
import de.dep.impl.DependencyImpl;

module middle {

    requires transitive bottom;

    opens de.dep;

    exports de.dep;
    uses Dependency;
    provides Dependency with DependencyImpl, DEpendencyImpl2;
}