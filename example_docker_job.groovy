freeStyleJob('freestyle job') {
	wrappers {
        	credentials('something')
	}
    scm {
	svn {
		location('https://svn2.prokarma.com/svn/dockertestapp/branches/junitmavenexample') {
                directory('proj2')
                depth(SvnDepth.EMPTY)
            }
        }
	
    }
    steps {
        maven('clean install')
    }
}

