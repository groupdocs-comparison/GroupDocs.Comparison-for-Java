{
    'variables': {
      .
      .
      .
    },
    'includes': [
      '../build/common.gypi',
    ],
    'target_defaults': {
      .
      .
      .
    },
    'targets': [
      {
        'target_name': 'target_1',
          .
          .
          .
      },
      {
        'target_name': 'target_2',
          .
          .
          .
      },
    ],
    'conditions': [
      ['OS=="linux"', {
        'targets': [
          {
            'target_name': 'linux_target_3',
              .
              .
              .
          },
        ],
      }],
      ['OS=="win"', {
        'targets': [
          {
            'target_name': 'windows_target_4',
              .
              .
              .
          },
        ],
      }, { # OS != "win"
        'targets': [
          {
            'target_name': 'non_windows_target_5',
              .
              .
              .
          },
      }],
    ],
  }