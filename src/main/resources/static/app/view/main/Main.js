/**
 * Created by anthony.kipkoech on 02/06/2017.
 */
Ext.define('AutoXpress.view.main.Main',{
    extend: 'Ext.panel.Panel',
    alias: 'widget.main',

    requires: ['Ext.plugin.Viewport','AutoXpress.view.main.MainModel','AutoXpress.view.main.MainController'],
    layout: 'accordion',
    controller: 'main',
    viewModel: 'main',
    ui: 'navigation',
    items: [
        {
            xtype: 'gridpanel',
            alias: 'personnelList',
            title: 'Inspection',
            store: 'personnel',
            columns: [
                { text: 'Name', dataIndex: 'name', flex: 1 },
                { text: 'Email', dataIndex: 'email', flex: 1 },
                { text: 'Phone', dataIndex: 'phone', flex: 1 }
            ]
        },
        {
            xtype: 'gridpanel',
            alias: 'personnelList',
            title: 'Vehicle',
            store: 'personnel',
            columns: [
                { text: 'Name', dataIndex: 'name', flex: 1 },
                { text: 'Email', dataIndex: 'email', flex: 1 },
                { text: 'Phone', dataIndex: 'phone', flex: 1 }
            ]
        }
    ]
});
