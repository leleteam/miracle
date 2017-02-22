var gulp = require('gulp');

var revCollector = require('gulp-rev-collector');

var sourcePath = {
    'layout'   : '../src/main/resources/templates/admin/layout/**/*',
    'user'     : '../src/main/resources/templates/admin/user/**/*',
    'business' : '../src/main/resources/templates/admin/business/**/*',
    'index'    : '../src/main/resources/templates/admin/index.html',
    'manifest' : 'dist/rev/*.json'
};

var distPath = {
    'html'     : '../src/main/resourceTest/templates/admin'
};

gulp.task('replaceTpl',function(){
    setTimeout(function(){
        gulp.src([sourcePath.manifest,sourcePath.index])
            .pipe( revCollector() )
            .pipe(gulp.dest(distPath.html));
    },3000);
});