Ext.define('AutoXpress.controller.RoutesController', {
    extend: 'Ext.app.Controller',
    
    routes: {
        'users': {
            before: 'checkIsAdmin',
            action: ''
        }
    },
    init: function () {

    },

    handleSessionCheck: function (beSuperAdmin,beAdmin, args) {
        args    = Ext.Array.slice(args);
        var me      = this,
            action  = args[args.length - 1],
            app     = AutoXpress.app;

        if(app.appready){
            if(AutoXpress.user){
                if(!beAdmin || AutoXpress.user.user_type === 'admin'){
                    action.resume();
                } else {
                    action.stop();
                    me.redirectTo('home');
                }
            } else {
                action.stop();
                me.redirectTo('login');
            }
        } else {
            app.on(
                'appready',
                Ext.Function.bind(me.handleSessionCheck, me, [beAdmin,args]),
                me,
                { single : true}
            );
        }

    },

    checkSession: function () {
        this.handleSessionCheck(false,false, arguments);
    },

    checkIsAdmin: function () {
        this.handleSessionCheck(false,true, arguments);
    },

    checkIsSuperAdmin: function () {

    }
    
});
