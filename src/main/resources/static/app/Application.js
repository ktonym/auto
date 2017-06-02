/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */
Ext.define('AutoXpress.Application', {
    extend: 'Ext.app.Application',

    name: 'AutoXpress',

    stores: [
        // TODO: add global / shared stores here
    ],

    launch: function () {
        Ext.Ajax.request({
            url: '/session',
            scope: this,
            failure: function () {
                this.onUser();
            },
            success: function (response) {
                this.onUser(
                    AutoXpress.user = Ext.decode(response.responseText)
                );
            }
        });
    },

    onUser: function (user) {
        this.appready = true;
        this.fireEvent('appready',this,user);
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});
