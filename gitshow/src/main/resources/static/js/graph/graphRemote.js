// import G6 from '@antv/g6';

G6.registerNode('card-node', {
    draw: function drawShape(cfg, group) {
        const r = 2;
        const color = '#5B8FF9';
        const w = cfg.size[0];
        const h = cfg.size[1];
        const shape = group.addShape('rect', {
            attrs: {
                x: -w / 2,
                y: -h / 2,
                width: w, //200,
                height: h, // 60
                stroke: color,
                radius: r,
                fill: '#fff',
            },
            name: 'main-box',
            draggable: true,
        });

        group.addShape('rect', {
            attrs: {
                x: -w / 2,
                y: -h / 2,
                width: w, //200,
                height: h / 2, // 60
                fill: color,
                radius: [r, r, 0, 0],
            },
            name: 'title-box',
            draggable: true,
        });

        // title text
        group.addShape('text', {
            attrs: {
                textBaseline: 'top',
                x: -w / 2 + 8,
                y: -h / 2 + 2,
                lineHeight: 20,
                text: cfg.id,
                fill: '#fff',
            },
            name: 'title',
        });
        cfg.children &&
        group.addShape('marker', {
            attrs: {
                x: w / 2,
                y: 0,
                r: 6,
                cursor: 'pointer',
                symbol: G6.Marker.collapse,
                stroke: '#666',
                lineWidth: 1,
                fill: '#fff',
            },
            name: 'collapse-icon',
        });
        group.addShape('text', {
            attrs: {
                textBaseline: 'top',
                x: -w / 2 + 8,
                y: -h / 2 + 24,
                lineHeight: 20,
                text: 'description',
                fill: 'rgba(0,0,0, 1)',
            },
            name: `description`,
        });
        return shape;
    },
    setState(name, value, item) {
        if (name === 'collapsed') {
            const marker = item.get('group').find((ele) => ele.get('name') === 'collapse-icon');
            const icon = value ? G6.Marker.expand : G6.Marker.collapse;
            marker.attr('symbol', icon);
        }
    },
});

const data = {
    id: 'A',
    children: [
        {
            id: 'A1',
            children: [
                { id: 'A11' ,
                    children: [
                        { id: 'A111' ,
                            children:[
                                {id: 'A1111'}
                            ]
                        }]
                }],
        },
        {
            id: 'A2',
            children: [
                {
                    id: 'A21',
                    children: [{ id: 'A211' }],
                },
            ],
        },
    ],
};

const width = document.getElementById('remote').scrollWidth;
const height = document.getElementById('remote').scrollHeight || 500;

const graphRemote = new G6.TreeGraph({
    container: 'remote',
    width: 1600,
    height: 150,
    defaultNode: {
        type: 'card-node',
        size: [100, 40],
    },
    defaultEdge: {
        type: 'cubic-horizontal',
        style: {
            endArrow: true,
        },
    },
    layout: {
        type: 'indented',
        direction: 'LR',//（左）LR。（中）RL。（右）H。
        dropCap: false,
        indent: 200,
        getHeight: () => {
            return 60;
        },
    },
});

graphRemote.data(data);
graphRemote.render();
graphRemote.fitView();
graphRemote.on('node:click', (e) => {
    if (e.target.get('name') === 'collapse-icon') {
        e.item.getModel().collapsed = !e.item.getModel().collapsed;
        graphRemote.setItemState(e.item, 'collapsed', e.item.getModel().collapsed);
        graphRemote.layout();
    }
});
