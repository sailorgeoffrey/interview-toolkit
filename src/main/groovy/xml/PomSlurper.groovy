package xml

class PomSlurper {

    static class GAV {
        String groupId, artifactId, version
        boolean visited
        List<GAV> children

        GAV(groupId, artifactId, version) {
            this.groupId = groupId
            this.artifactId = artifactId
            this.version = version
        }

        def getRepoUrl() {
            return "http://search.maven.org/remotecontent?filepath=/${groupId.replaceAll('\\.', '/')}/$artifactId/$version/$artifactId-${version}.pom"
        }

        def getUnvisitedChildNode() {
            for (child in getChildren()) if (!child.isVisited()) return child
        }

        def getChildren() {
            if (children == null) {
                children = fetchChildrenFromWeb()
            }
            return children
        }

        def fetchChildrenFromWeb() {

            def pomData = new URL(getRepoUrl()).getText()

            def parsed = new XmlSlurper().parseText(pomData)

            def children = []

            for (dep in parsed.dependencies.children()) {

                children.add(new GAV(dep.groupId.toString(), dep.artifactId.toString(), dep.version.toString()))

            }
            return children
        }

        @Override
        public String toString() {
            return "$groupId:$artifactId:$version"
        }
    }

    public static void main(String[] args) {

        int level = 0

        def root = new GAV("org.springframework", "spring-core", "4.0.1.RELEASE")
        println root

        Stack<GAV> todo = new Stack<>()
        todo.push root

        while (!todo.isEmpty()) {
            GAV item = todo.peek();
            GAV child = item.getUnvisitedChildNode();
            if (child != null) {
                level++
                child.visited = true;
                println(indent(level) + child.toString())
                todo.push(child);
            } else {
                todo.pop();
                level--
            }
        }

    }

    static String indent(int level) {
        def s = ""
        for (int i = 0; i < level; i++) {
            s = s + "    "
        }
        return s
    }

}