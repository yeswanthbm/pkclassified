freeStyleJob('freestyle job') {
	credentials('something')
    scm {
	svn {
		location('https://svn2.prokarma.com/svn/dockertestapp/branches/junitmavenexample') {
                depth(SvnDepth.EMPTY)
            }
        }
	
    }
    steps {
        maven('clean install')
    }
}

